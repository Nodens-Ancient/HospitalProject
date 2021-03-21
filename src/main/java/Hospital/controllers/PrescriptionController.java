package Hospital.controllers;

import Hospital.dao.PrescriptionsDAO;
import Hospital.models.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {
    private static final String INDEX = "prescriptions/AllPrescriptions";
    private static final String SHOW = "prescriptions/show";
    private final PrescriptionsDAO prescriptionsDAO;

    @Autowired
    public PrescriptionController(PrescriptionsDAO prescriptionsDAO) {
        this.prescriptionsDAO = prescriptionsDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("prescriptions", prescriptionsDAO.index());
        return INDEX;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("prescriptions", prescriptionsDAO.show(id));
        return SHOW;
    }

    @GetMapping("/new")
    public String newPrescription(@ModelAttribute("prescription") Prescription prescription) {
        return "prescriptions/NewPrescription";
    }

    @PostMapping()
    public String create(@ModelAttribute("diagnose") @Valid Prescription prescription, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "prescriptions/NewPrescription";

        prescriptionsDAO.save(prescription);
        return "redirect:/prescriptions";
    }
}
