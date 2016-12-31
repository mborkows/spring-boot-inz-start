package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sample.domain.Declaration;
import sample.domain.Employee;
import sample.domain.Forms.TermForm;
import sample.domain.Forms.UserWeekForm;
import sample.repository.DeclarationRepository;
import sample.repository.EmployeeRepository;

import java.sql.Time;

import java.util.Date;
import java.util.List;


/**
 * Created by marek on 23.11.16.
 */
@Controller
public class UserWeekController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeclarationRepository declarationRepository;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public UserWeekController(EmployeeRepository e, DeclarationRepository d) {
        this.employeeRepository = e;
        this.declarationRepository = d;
    }

    @GetMapping("/declaration")
    public String declarationForm(Model model) {
        model.addAttribute("termForm", new TermForm());
        return "declaration";
    }

    @PostMapping("/declaration")
    public String declarationSubmit(@ModelAttribute TermForm termForm) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        Employee e = employeeRepository.findByEmail(name);

        Declaration d = new Declaration();

        d.setBegin_time(termForm.getBegin_time());
        d.setEnd_time(termForm.getEnd_time());
        d.setDay(termForm.getDay());
        d.setEmployee(e);
        declarationRepository.save(d);
        return "redirect:/declarations";
    }

    @GetMapping("/declarations")
    public String declarationList(Model model) {
        model.addAttribute("declarations", declarationRepository.findAll());
        return "declaration_list";
    }


    @GetMapping("/userWeek")
    public String userWeekForm(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Employee e = employeeRepository.findByEmail(name);

        UserWeekForm wfd = matchDeclarationFormAndList(new UserWeekForm(), declarationRepository.findByEmployee(e));

        model.addAttribute("wfd", wfd);
        return "userWeek";
    }

    @PostMapping("/userWeek")
    public String userWeekSubmit(@ModelAttribute UserWeekForm wfd_new) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        Employee e = employeeRepository.findByEmail(name);

        UserWeekForm wfd_old = matchDeclarationFormAndList(new UserWeekForm(), declarationRepository.findByEmployee(e));

        Boolean declarations_new[][] = wfd_new.getDeclaration();
        Boolean declatations_old[][] = wfd_old.getDeclaration();
        int id[][] = wfd_old.getId();

        Date week[] = wfd_new.getWeek();


        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (!declarations_new[i][j].equals(declatations_old[i][j])) {
                    Declaration d = new Declaration();
                    d.setDay((java.sql.Date) week[i]);
                    d.setEmployee(e);
                    if (j == 0) {
                        d.setBegin_time(Time.valueOf("00:00:00"));
                        d.setEnd_time(Time.valueOf("08:00:00"));
                    } else if (j == 1) {
                        d.setBegin_time(Time.valueOf("08:00:00"));
                        d.setEnd_time(Time.valueOf("16:00:00"));
                    } else if (j == 2) {
                        d.setBegin_time(Time.valueOf("16:00:00"));
                        d.setEnd_time(Time.valueOf("23:59:59"));
                    } else {
                        System.err.print("Blad");
                    }

                    if(declarations_new[i][j] == true)
                        declarationRepository.save(d);
                    if(declarations_new[i][j] == false)
                        declarationRepository.delete(id[i][j]);
                }

            }
        }

        return "redirect:/userWeek";
    }

    public UserWeekForm matchDeclarationFormAndList(UserWeekForm wdf, List<Declaration> declarationList) {

        java.sql.Date[] week = wdf.getWeek();

        Boolean declaration[][] = new Boolean[7][3];
        Boolean approved[][] = new Boolean[7][3];
        int id [][] = new int[7][3];

        for (Declaration d : declarationList) {
            for (int i = 0; i < 7; i++) {
                if (week[i].equals(d.getDay())) {
                    if (d.getBegin_time().equals(Time.valueOf("00:00:00"))) {
                        declaration[i][0] = true;
                        id[i][0] = d.getId();
                        if (d.isApproved())
                            approved[i][0] = true;
                        else approved[i][0] = false;
                    } else if (d.getBegin_time().equals(Time.valueOf("08:00:00"))) {
                        declaration[i][1] = true;
                        id[i][1] = d.getId();
                        if (d.isApproved())
                            approved[i][1] = true;
                        else approved[i][1] = false;
                    } else if (d.getBegin_time().equals(Time.valueOf("16:00:00"))) {
                        declaration[i][2] = true;
                        id[i][2] = d.getId();
                        if (d.isApproved())
                            approved[i][2] = true;
                        else approved[i][2] = false;
                    }

                }

            }
        }

        wdf.setDeclaration(declaration);
        wdf.setApproved(approved);
        wdf.setId(id);

        return wdf;
    }

}