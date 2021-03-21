package Hospital.controllers;

import Hospital.dao.ManipulationsDAO;
import Hospital.models.Manipulations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/manipulations")
public class ManipulationController {
    private static final String INDEX = "manipulations/AllManipulations";
    private static final String SHOW = "manipulations/show";
    private final ManipulationsDAO manipulationsDAO;
    @Autowired
    public ManipulationController(ManipulationsDAO manipulationsDAO) {
        this.manipulationsDAO = manipulationsDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("manipulations", manipulationsDAO.index());
        return INDEX;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("manipulations", manipulationsDAO.show(id));
        return SHOW;
    }

    @GetMapping("/new")
    public String newManipulation(@ModelAttribute("manipulations") Manipulations manipulations) {
        return "manipulations/NewManipulation";
    }

    @PostMapping()
    public String create(@ModelAttribute("diagnose") @Valid Manipulations manipulations, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "manipulations/NewManipulation";

        manipulationsDAO.save(manipulations);
        return "redirect:/manipulations";
    }
}
