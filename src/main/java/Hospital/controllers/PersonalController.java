package Hospital.controllers;

import Hospital.dao.PersonalDAO;
import Hospital.models.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    private final PersonalDAO personalDAO;

    @Autowired
    public PersonalController(PersonalDAO personalDAO){
        this.personalDAO = personalDAO;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("personal", personalDAO.index());
        return "personal/AllPersonal";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("personal", personalDAO.show(id));
        return "personal/show";
    }

    @GetMapping("/new")
    public String newPersonal(@ModelAttribute("personal") Personal personal) {
        return "personal/NewPersonal";
    }

    @PostMapping()
    public String create(@ModelAttribute("personal") @Valid Personal personal, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "personal/NewPersonal";

        personalDAO.save(personal);
        return "redirect:/personal";
    }

//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("personal") Person person) {
//        return "personal/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("personal") @Valid Personal personal,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "personal/new";
//
//        patientlDAO.save(personal);
//        return "redirect:/personal";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("personal", patientlDAO.show(id));
//        return "personal/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") @Valid Personal personal, BindingResult bindingResult,
//                         @PathVariable("id") int id) {
//        if (bindingResult.hasErrors())
//            return "personal/edit";
//
//        patientlDAO.update(id, personal);
//        return "redirect:/personal";
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personalDAO.delete(id);
        return "redirect:/personal";
    }
}
