package Hospital.controllers;
import Hospital.dao.PatientDAO;
import Hospital.models.Patients;
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
    private static final String SHOW = "patients/AllPatients";

    private final PatientDAO patientDAO;

    @Autowired
    public PatientController(PatientDAO patientDAO){
        this.patientDAO = patientDAO;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("patients", patientDAO.index());
        return INDEX;
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("patients", patientDAO.show(id));
        return SHOW;
    }
    @GetMapping("/new")
    public String newPersonal(@ModelAttribute("patient") Patients patients) {
        return "patients/NewPatient";
    }

    @PostMapping()
    public String create(@ModelAttribute("patient") @Valid Patients patients, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "patients/NewPatient";

        patientDAO.save(patients);
        return "redirect:/patients";
    }
//    @GetMapping("/new")
//    public String newPatient(@ModelAttribute("patients") Patients patients) {
//        return BASE_URL + "/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("patients") @Valid Patients patients,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return BASE_URL + "/new";
//
//        patientDAO.save(patients);
//        return "redirect:/" + BASE_URL ;
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("patient", patientDAO.show(id));
//        return BASE_URL + "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("patients") @Valid Patients patients, BindingResult bindingResult,
//                         @PathVariable("id") int id) {
//        if (bindingResult.hasErrors())
//            return  BASE_URL + "edit";
//
//        patientDAO.update(id, patients);
//        return "redirect:/" + BASE_URL;
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        patientDAO.delete(id);
//        return "redirect:/" + BASE_URL;
//    }
}