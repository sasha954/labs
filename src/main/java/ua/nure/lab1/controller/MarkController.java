package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.service.MarkService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    private MarkService markService;

    @GetMapping
    public ModelAndView getMarks() {
        ModelAndView modelAndView = new ModelAndView("mark");

        Map<String, List<Mark>> marksMap = markService.getMark();
        modelAndView.addObject("marksMap", marksMap);

        return modelAndView;
    }
}
