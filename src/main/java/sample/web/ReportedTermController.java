package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sample.domain.TermForm;
import sample.repository.EmployeeRepository;


/**
 * Created by marek on 15.11.16.
 */
@Controller
public class ReportedTermController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public ReportedTermController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/term")
    public String termForm(TermForm termForm) {
        return "term";
    }

    @PostMapping("/term")
    public String termSubmit(TermForm termForm){
//        Employee e = employeeRepository.findOne(termForm.getEmployee_id());
//        Day d = dayRepository.findOne(termForm.getDay_id());
        return "redirect:/terms";
    }

    @GetMapping("/terms")
    public String showTerms(Model model){
    //    model.addAttribute("terms", reportedTermRepository.findAll());
        return "term_list";
    }

    @GetMapping("/usun")
    public String usunTerms(Model model){
     //   model.addAttribute("term", new ReportedTerm());
        return "usun";
    }

}
