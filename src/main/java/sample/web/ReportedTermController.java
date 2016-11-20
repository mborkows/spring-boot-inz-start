package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sample.domain.ReportedTerm;
import sample.domain.TermForm;
import sample.repository.DayRepository;
import sample.repository.EmployeeRepository;
import sample.repository.ReportedTermRepository;


/**
 * Created by marek on 15.11.16.
 */
@Controller
public class ReportedTermController {

    private ReportedTermRepository reportedTermRepository;
    private EmployeeRepository employeeRepository;
    private DayRepository dayRepository;

    @Autowired
    public ReportedTermController(EmployeeRepository employeeRepository, DayRepository dayRepository, ReportedTermRepository reportedTermRepository){
        this.reportedTermRepository = reportedTermRepository;
        this.employeeRepository = employeeRepository;
        this.dayRepository = dayRepository;
    }

    @GetMapping("/term")
    public String termForm(TermForm termForm) {
        return "term";
    }

    @PostMapping("/term")
    public String termSubmit(TermForm termForm){
//        Employee e = employeeRepository.findOne(termForm.getEmployee_id());
//        Day d = dayRepository.findOne(termForm.getDay_id());
        ReportedTerm reportedTerm = new ReportedTerm(termForm.getBegin_time(), termForm.getEnd_time());
        reportedTerm.setEmployee(employeeRepository.findOne(termForm.getEmployee_id()));
        reportedTerm.setDay(dayRepository.findOne(termForm.getDay_id()));
        reportedTermRepository.save(reportedTerm);
        return "redirect:/terms";
    }

    @GetMapping("/terms")
    public String showTerms(Model model){
        model.addAttribute("terms", reportedTermRepository.findAll());
        return "term_list";
    }

    @GetMapping("/usun")
    public String usunTerms(Model model){
        model.addAttribute("term", new ReportedTerm());
        return "usun";
    }

}
