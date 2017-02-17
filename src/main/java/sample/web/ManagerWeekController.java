package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sample.domain.Declaration;
import sample.domain.Employee;
import sample.domain.Forms.ManagerWeekForm;
import sample.domain.MyCalendar;
import sample.repository.DeclarationRepository;
import sample.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by marek on 31.12.16.
 */
@Controller
public class ManagerWeekController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeclarationRepository declarationRepository;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    private MyCalendar myCalendar = new MyCalendar();

    @GetMapping("/managerView")
    public String managerViewForm(@RequestParam("date") Date date, ModelMap model) {

        Employee currentUser = currentUser();
        List<Employee> workers = employeeRepository.findByFirm(currentUser.getFirm());
        myCalendar.setMyCalendarUlitDate(date);
        java.sql.Date[] week = myCalendar.generateWeekFromDate(myCalendar.getSqlDate());
        List<List<Declaration>> declarationsArray = workersWeekDeclarations(workers, week[0]);

        model.addAttribute("workers", workers);
        model.addAttribute("week", week);

        ManagerWeekForm mwf = new ManagerWeekForm(workers, declarationsArray, week);

        model.addAttribute("mwf", mwf);
        return "managerView";
    }

//    @GetMapping("/managerView")
//    public String managerViewForm(@ModelAttribute DateForm dateForm, Model model) {
//
//        Employee currentUser = currentUser();
//        List<Employee> workers = employeeRepository.findByFirm(currentUser.getFirm());
//        Date[] week = myCalendar.generateWeekFromDate(dateForm.getDay());
//        List<List<Declaration>> declarationsArray = workersWeekDeclarations(workers, week[0]);
//
//        ManagerWeekForm mwf = new ManagerWeekForm(workers, declarationsArray, week);
//
//        model.addAttribute("mwf", mwf);
//        return "managerView";
//    }

    @PostMapping("/managerView")
    public String managerViewSubmit(@ModelAttribute("workers") List<Employee> workers, @ModelAttribute("week") java.sql.Date[] week, @ModelAttribute("mwf") ManagerWeekForm mwf_new) {

        Employee currentUser = currentUser();
        List<List<Declaration>> declarationsArray = workersWeekDeclarations(workers, week[0]);
        ManagerWeekForm mwf_old = new ManagerWeekForm(workers, declarationsArray, week);

        for (int i = 0; i < workers.size(); i++) {
            for (int j = 0; j < 21; j++) {
                if (!mwf_new.getApproved()[i][j].equals(mwf_old.getApproved()[i][j])) {
                    Declaration d = declarationRepository.findOne(mwf_new.getId()[i][j]);
                    d.setApproved(mwf_new.getApproved()[i][j]);
                    declarationRepository.save(d);
                }
            }
        }

        return "redirect:/hello";
    }

    /*Zwraca obiekt klasy Employee ktory korzysta obecnie z tej funkcji*/
    Employee currentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        return employeeRepository.findByEmail(name);
    }

    private List<List<Declaration>> workersWeekDeclarations(List<Employee> workers, java.sql.Date weekBegin) {

        myCalendar.setMyCalendarSqlDate(weekBegin);
        Date[] week = myCalendar.generateWeekFromDate(weekBegin);
        java.sql.Date weekEnd = myCalendar.add(6);

        List<List<Declaration>> declarationsArray = new ArrayList<List<Declaration>>();
        for (Employee e : workers) {
            List<Declaration> tmpList = new ArrayList<Declaration>();
            tmpList = declarationRepository.findByEmployeeAndDayBetween(e, weekBegin, weekEnd);
            declarationsArray.add(tmpList);
        }

        return declarationsArray;
    }

}
