package Hospital.controllers;

import Hospital.dao.AvailableManipulationsDAO;
import Hospital.models.tablemodels.AvailableManipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/availablemanipulations")
public class AvailableManipulationsController {
    private static final String ALL_INFO = "availablemanipulations/AllAvailableManipulations";
    private static final String SHOW = "availablemanipulations/show";
    private final AvailableManipulationsDAO availableManipulationsDAO;

    @Autowired
    public AvailableManipulationsController(AvailableManipulationsDAO availableManipulationsDAO) {
        this.availableManipulationsDAO = availableManipulationsDAO;
    }
    @GetMapping
    public String getAllTable(Model model){
        model.addAttribute("avmanipulations", availableManipulationsDAO.getAllTable());
        return ALL_INFO;
    }

    @GetMapping("/{id")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("avmanipulations", availableManipulationsDAO.show(id));
        return SHOW;
    }
    @GetMapping("/new")
    public String newAvailableManipulation(@ModelAttribute("avmanipulation") AvailableManipulation availableManipulation) {
        return "availablemanipulations/NewAvailableManipulation";
    }

    @PostMapping()
    public String create(@ModelAttribute("diagnose") @Valid AvailableManipulation availableManipulation, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "availablemanipulations/NewAvailableManipulation";

        availableManipulationsDAO.save(availableManipulation);
        return "redirect:/availablemanipulations";
    }
}
