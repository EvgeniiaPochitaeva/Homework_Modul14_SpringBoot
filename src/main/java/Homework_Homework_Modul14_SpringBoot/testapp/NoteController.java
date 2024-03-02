package Homework_Homework_Modul14_SpringBoot.testapp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired     private final NoteService noteService;

    @GetMapping(value = "/list")
    public ModelAndView noteList() {
        ModelAndView result = new ModelAndView("note-list");
        result.addObject("note", noteService.listAll());
        return result;
    }


    @PostMapping(value = "/delete")
    public RedirectView delete(@RequestParam(name = "id") long id) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/note/list");
        noteService.deleteById(id);
        return redirectView;
    }


    @GetMapping(value = "/edit")
    public String editNote(Model model, @RequestParam(name = "id") long id) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return ("note-edit");
    }


    @PostMapping(value = "/edit")
    public RedirectView edit(@ModelAttribute Note note) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/note/list");
        noteService.update(note);
        return redirectView;
    }
}
