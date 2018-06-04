package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.service.CriteriaService;

import java.util.List;

@Controller
@RequestMapping("/criteria")
public class CriteriaController {

    @Autowired
    private CriteriaService criteriaService;

    @GetMapping
    public ModelAndView getCriteria() {
        ModelAndView modelAndView = new ModelAndView("criteria");

        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        modelAndView.addObject(criteriaList);

        return modelAndView;
    }
}
