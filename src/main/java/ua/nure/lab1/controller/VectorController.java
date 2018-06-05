package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.dto.VectorDto;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.domain.entity.Vector;
import ua.nure.lab1.service.AlternativeService;
import ua.nure.lab1.service.MarkService;
import ua.nure.lab1.service.VectorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vectors")
public class VectorController {

    @Autowired
    private VectorService vectorService;
    @Autowired
    private MarkService markService;
    @Autowired
    private AlternativeService alternativeService;

    @GetMapping
    public ModelAndView getVectors() {
        ModelAndView modelAndView = new ModelAndView("vector");

        List<Vector> vectorList = vectorService.getAllVectors();
        Map<String, List<Mark>> markMap = markService.getMark();
        List<Alternative> alternatives = alternativeService.getAllAlternative();

        modelAndView.addObject(vectorList)
                .addObject("markMap", markMap)
                .addObject("alternativeList", alternatives);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView createNewVector(@RequestParam("alternativeId") int alternativeId,
                                        @RequestParam("markId") String[] marksId) {

        System.out.println(alternativeId + " : " + Arrays.toString(marksId));

        return new ModelAndView("redirect:/vectors");
    }
}
