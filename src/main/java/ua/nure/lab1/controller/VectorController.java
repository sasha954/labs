package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.entity.Vector;
import ua.nure.lab1.service.VectorService;

import java.util.List;

@Controller
@RequestMapping("/vectors")
public class VectorController {

    @Autowired
    private VectorService vectorService;

    @GetMapping
    public ModelAndView getVectors() {
        ModelAndView modelAndView = new ModelAndView("vector");

        List<Vector> vectorList = vectorService.getAllVectors();
        modelAndView.addObject(vectorList);

        return modelAndView;
    }
}
