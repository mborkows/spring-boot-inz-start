package sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sample.domain.Tag;
import sample.repository.TagRepository;

/**
 * Created by mwal on 10/23/16.
 */
@Controller
public class TagController {

    private TagRepository tagRepo;

    @Autowired
    public TagController(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    @GetMapping("/tag")
    public String tagForm(Model model) {
        model.addAttribute("tag", new Tag());
        return "tag";
    }

    @PostMapping("/tag")
    public String tagSubmit(@ModelAttribute Tag tag, Model model){
        tagRepo.save(tag);
        return "redirect:/tags";
    }

    @GetMapping("/tags")
    public String showTags(Model model){
        model.addAttribute("tags", tagRepo.findAll());
        return "tag_list";
    }
}

