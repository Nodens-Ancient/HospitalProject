package Hospital.controllers;

import Hospital.dao.QualificationDAO;
import Hospital.models.tablemodels.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/qualification")
public class QualificationController {
    private static final String INDEX = "qualifications/allQualifications";
    private static final String SHOW = "qualifications/show";
    private final QualificationDAO qualificationDAO;

    @Autowired
    public QualificationController(QualificationDAO qualificationDAO) {
        this.qualificationDAO = qualificationDAO;
    }

    @GetMapping()
    public String getAllTable(Model model){
        model.addAttribute("qualifications", qualificationDAO.getAllTable());
        return INDEX;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("qualifications", qualificationDAO.show(id));
        return SHOW;
    }

    @GetMapping("/new")
    public String newPrescription(@ModelAttribute("qualification") Qualification qualification) {
        return "qualifications/newQualification";
    }

    @PostMapping()
    public String create(@ModelAttribute("diagnose") @Valid Qualification qualification, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "qualifications/newQualification";

        qualificationDAO.save(qualification);
        return "redirect:/qualification";
    }
}
