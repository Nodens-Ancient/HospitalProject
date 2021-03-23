package Hospital.controllers;

import Hospital.dao.PersonalDAO;
import Hospital.models.tablemodels.Personal;
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
    public String getAllTable(Model model) {
        model.addAttribute("personal", personalDAO.getAllTable());
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

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personalDAO.delete(id);
        return "redirect:/personal";
    }
}
