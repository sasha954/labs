package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.service.AlternativeService;

import java.util.List;

@RestController
@RequestMapping("/alternatives")
public class AlternativeController {
    private static final String ALTERNATIVE_LIST = "alternativeList";

    @Autowired
    private AlternativeService alternativeService;

    @GetMapping
    public ModelAndView showAlternatives() {
        List<Alternative> alternatives = alternativeService.getAllAlternative();

        ModelAndView modelAndView = new ModelAndView("alternative");
        modelAndView.addObject(ALTERNATIVE_LIST, alternatives);
        modelAndView.setStatus(HttpStatus.OK);

        return modelAndView;
    }
}
