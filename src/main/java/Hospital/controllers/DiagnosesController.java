package Hospital.controllers;

import Hospital.dao.DiagnosesDAO;
import Hospital.models.tablemodels.Diagnose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/diagnoses")
public class DiagnosesController {
    private static final String INDEX = "diagnoses/AllDiagnoses";
    private static final String SHOW = "diagnoses/show";
    private final DiagnosesDAO diagnosesDAO;

    @Autowired
    public DiagnosesController(DiagnosesDAO diagnosesDAO) {
        this.diagnosesDAO = diagnosesDAO;
    }
    @GetMapping
    public String getAllTable(Model model) {
        model.addAttribute("diagnose", diagnosesDAO.getAllTable());
        return INDEX;
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("diagnose", diagnosesDAO.show(id));
        return SHOW;
    }

    @GetMapping("/new")
    public String NewDiagnose(@ModelAttribute("diagnose") Diagnose diagnose) {
        return "diagnoses/NewDiagnose";
    }

    @PostMapping()
    public String create(@ModelAttribute("diagnose") @Valid Diagnose diagnose, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "patients/NewDiagnose";

        diagnosesDAO.save(diagnose);
        return "redirect:/diagnoses";
    }
}
