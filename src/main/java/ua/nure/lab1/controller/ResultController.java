package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.dto.ChosenAlternative;
import ua.nure.lab1.domain.entity.Alternative;
import ua.nure.lab1.domain.entity.Result;
import ua.nure.lab1.service.AlternativeService;
import ua.nure.lab1.service.ChooseService;
import ua.nure.lab1.service.ResultService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Controller
@RequestMapping("/results")
public class ResultController {

    public static final String REDIRECT_RESULTS = "redirect:/results";
    @Autowired
    private ResultService resultService;
    @Autowired
    private AlternativeService alternativeService;
    @Autowired
    private ChooseService chooseService;

    private ChosenAlternative firstAlternative;
    private ChosenAlternative secondAlternative;

    @GetMapping("/temp")
    public ModelAndView getResults() {
        ModelAndView modelAndView = new ModelAndView("result");

        List<Alternative> alternativeList = alternativeService.getAllAlternative();
        List<Result> results = resultService.getAllResult().stream().sorted(Comparator.comparing(Result::getRange))
                .collect(Collectors.toList());

        modelAndView.addObject("alternatives", alternativeList);
        modelAndView.addObject("results", results);

        return modelAndView;
    }

    @GetMapping
    public ModelAndView showChoose() {
        ModelAndView modelAndView = new ModelAndView("choose");

        firstAlternative = isNull(firstAlternative) && chooseService.hasNext() ? chooseService.nextAlternative() : firstAlternative;
        secondAlternative = isNull(secondAlternative) && chooseService.hasNext() ? chooseService.nextAlternative() : secondAlternative;

        if (nonNull(firstAlternative) && nonNull(secondAlternative)) {
            modelAndView.addObject("firstAlter", firstAlternative);
            modelAndView.addObject("secondAlter", secondAlternative);
        }

        if (!chooseService.hasNext()) {
            modelAndView.clear();
            modelAndView.setViewName("choose");
            List<Alternative> winner = chooseService.getWinner();
            modelAndView.addObject("winner", winner);
        }

        return modelAndView;
    }

    @PostMapping("/clear")
    public ModelAndView clear() {
        chooseService.clear();

        firstAlternative = chooseService.hasNext() ? chooseService.nextAlternative() : firstAlternative;
        secondAlternative = chooseService.hasNext() ? chooseService.nextAlternative() : secondAlternative;

        return new ModelAndView(REDIRECT_RESULTS);
    }


    @PostMapping("/choose-alternative")
    public ModelAndView selectAlternative(@RequestParam(value = "alternative-value")
                                                  String alternativeValue) {
        increaseAction(alternativeValue);

        if(chooseService.changeRow()) {
            firstAlternative = chooseService.hasNext() ? chooseService.nextAlternative() : firstAlternative;
        }

        secondAlternative = chooseService.hasNext() ? chooseService.nextAlternative() : secondAlternative;

        return new ModelAndView(REDIRECT_RESULTS);
    }

    private void increaseAction(String alternativeValue) {
        switch (alternativeValue) {
            case "left-alternative":
                firstAlternative.increaseMoreThanQuantity();
                secondAlternative.increaseLessThanQuantity();
                break;
            case "right-alternative" :
                firstAlternative.increaseLessThanQuantity();
                secondAlternative.increaseMoreThanQuantity();
                break;
            case "equals":
                firstAlternative.increaseEqualsQuantity();
                secondAlternative.increaseEqualsQuantity();
                break;
        }
    }

    @PostMapping("/temp")
    public ModelAndView createResult(@RequestParam("alternative-id") int altID) {
        Result result = new Result();
        result.setAlternative(alternativeService.getById(altID));

        resultService.createResult(result);
        return new ModelAndView("redirect:/results");
    }
}
