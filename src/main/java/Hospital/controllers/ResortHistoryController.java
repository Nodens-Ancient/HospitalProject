package Hospital.controllers;

import Hospital.dao.ResortHistoryDAO;
import Hospital.models.ResortHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/resorthistory")
public class ResortHistoryController {
    private static final String INDEX = "resorthistory/AllResortHistories";
    private static final String SHOW = "resorthistory/show";
    private final ResortHistoryDAO resortHistoryDAO;

    @Autowired
    public ResortHistoryController(ResortHistoryDAO resortHistoryDAO) {
        this.resortHistoryDAO = resortHistoryDAO;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("resorthistory", resortHistoryDAO.index());
        return INDEX;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("resorthistory", resortHistoryDAO.show(id));
        return SHOW;
    }

    @GetMapping("/new")
    public String newPrescription(@ModelAttribute("resorthistory") ResortHistory resortHistory) {
        return "resorthistory/newResortHistory";
    }

    @PostMapping()
    public String create(@ModelAttribute("resorthistory") @Valid ResortHistory resortHistory, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "resorthistory/newResortHistory";

        resortHistoryDAO.save(resortHistory);
        return "redirect:/resorthistory";
    }
}