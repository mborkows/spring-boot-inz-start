package sample.web;

/**
 * Created by mwal on 10/23/16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sample.domain.Note;
import sample.domain.Tag;
import sample.repository.NoteRepository;
import sample.repository.TagRepository;

import java.util.ArrayList;

@Controller
public class NoteController {

    private NoteRepository noteRepo;
    private TagRepository tagRepo;

    @Autowired
    public NoteController(NoteRepository noteRepo, TagRepository tagRepo) {
        this.noteRepo = noteRepo;
        this.tagRepo = tagRepo;
    }

    @GetMapping("/note")
    public String noteForm(Model model) {
        Note note = new Note();
        note.setTags(new ArrayList<Tag>());
        model.addAttribute("note", new Note());
        model.addAttribute("allTags", tagRepo.findAll());
        return "note";
    }

    @PostMapping("/note")
    public String noteSubmit(@ModelAttribute Note note, Model model) {
        noteRepo.save(note);
        return "redirect:/notes";
    }


    @GetMapping("/notes")
    public String showNotes(Model model){
        model.addAttribute("notes", noteRepo.findAll());
        return "note_list";
    }

}