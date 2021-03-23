package Hospital.controllers;
import Hospital.dao.PatientDAO;
import Hospital.models.tablemodels.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/patients")
public class PatientController {
    private static final String INDEX = "patients/AllPatients";
    private static final String SHOW = "patients/";

    private final PatientDAO patientDAO;

    @Autowired
    public PatientController(PatientDAO patientDAO){
        this.patientDAO = patientDAO;
    }
    @GetMapping()
    public String getAllTable(Model model) {
        model.addAttribute("patients", patientDAO.getAllTable());
        return INDEX;
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("patients", patientDAO.show(id));
        return SHOW;
    }
    @GetMapping("/new")
    public String newPersonal(@ModelAttribute("patient") Patient patient) {
        return "patients/NewPatient";
    }

    @PostMapping()
    public String create(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "patients/NewPatient";

        patientDAO.save(patient);
        return "redirect:/patients";
    }
}