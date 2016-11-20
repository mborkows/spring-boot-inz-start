package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sample.domain.Firm;
import sample.repository.FirmReposotory;

/**
 * Created by mwal on 10/23/16.
 */
@Controller
public class FirmController {

    private FirmReposotory firmRepo;

    @Autowired
    public FirmController(FirmReposotory firmRepo) {
        this.firmRepo = firmRepo;
    }

    @GetMapping("/firm")
    public String firmForm(Model model) {
        model.addAttribute("firm", new Firm());
        return "firm";
    }

    @PostMapping("/firm")
    public String firmSubmit(@ModelAttribute Firm firm){
        firmRepo.save(firm);
        return "redirect:/firms";
    }

    @PostMapping("/firm/delete")
    public String firmDelete(@PathVariable Long id) {
        firmRepo.delete(id);
        return "firms";
    }

    @GetMapping("/firms")
    public String showFirms(Model model){
        model.addAttribute("firms", firmRepo.findAll());
        model.addAttribute("firm_to_delete", new Firm());
        return "firm_list";
    }
}

