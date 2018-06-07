package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.dto.MarkDto;
import ua.nure.lab1.domain.entity.Criteria;
import ua.nure.lab1.domain.entity.Mark;
import ua.nure.lab1.service.CriteriaService;
import ua.nure.lab1.service.MarkService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    private MarkService markService;
    @Autowired
    private CriteriaService criteriaService;

    @GetMapping
    public ModelAndView getMarks() {
        ModelAndView modelAndView = new ModelAndView("mark");

        Map<String, List<Mark>> marksMap = markService.getMark();
        List<Criteria> criteriaList = criteriaService.getAllCriteria();

        modelAndView.addObject("marksMap", marksMap)
                .addObject("criteriaList", criteriaList);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView createNewMark(MarkDto dto) {
        System.out.println(dto);

        markService.createMark(dto);

        return new ModelAndView("redirect:/marks");
    }

    @PostMapping("/update")
    public ModelAndView updateMark(Mark mark) {
        System.out.println(mark);

        markService.updateMark(mark);

        return new ModelAndView("redirect:/marks");
    }

    @GetMapping("/delete")
    public ModelAndView removeMark(@RequestParam("mark-id") int markId) {
        markService.removeMark(markId);

        return new ModelAndView("redirect:/marks");
    }
}
