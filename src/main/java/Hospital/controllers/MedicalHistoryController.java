package Hospital.controllers;

import Hospital.dao.MedicalHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicalHistory")
public class MedicalHistoryController {
    MedicalHistoryDAO medicalHistoryDAO;

    @Autowired
    public MedicalHistoryController(MedicalHistoryDAO medicalHistoryDAO){
        this.medicalHistoryDAO = medicalHistoryDAO;
    }

    @GetMapping("/{id}")
    public String getMedicalHistory(@PathVariable("id") int id, Model model){
        model.addAttribute("medicalHistory", medicalHistoryDAO.getMedicalHistory(id));
        return "medicalhistory/MedicalHistoryShow";
    }
}
