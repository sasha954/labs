package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.dto.AlternativeDto;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.service.AlternativeService;
import ua.nure.lab1.service.MarkService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vectors")
public class VectorController {

    @Autowired
    private MarkService markService;
    @Autowired
    private AlternativeService alternativeService;

    @GetMapping
    public ModelAndView getVectors() {
        ModelAndView modelAndView = new ModelAndView("vector");

        List<Alternative> alternatives = alternativeService.getAllAlternative();
        Map<String, List<Mark>> markMap = markService.getMark();

        modelAndView
                .addObject("markMap", markMap)
                .addObject("alternativeList", alternatives);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView createNewVector(AlternativeDto alternativeDto) {
        alternativeService.addMarksToAlternative(alternativeDto);

        return new ModelAndView("redirect:/vectors");
    }
}
