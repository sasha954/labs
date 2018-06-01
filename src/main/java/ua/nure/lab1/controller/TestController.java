package ua.nure.lab1.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/tests")
public class TestController {

    private ModelAndView modelAndView;

    @PostConstruct
    private void init() {
        modelAndView = new ModelAndView("test");
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Congratulations!!!");
    }

    @GetMapping("/jsp-test")
    public ModelAndView testJsp() {
        modelAndView.addObject("message", "Hello JSP");
        modelAndView.getModel().remove("message2");
        return modelAndView;
    }

    @PostMapping(value = "/jsp-test", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postTest(TestDTO testDTO) {
        modelAndView.addObject("message1", testDTO.getLine1() + " : " + testDTO.getLine2());
        modelAndView.addObject("message2", testDTO.getLine2() + " : " + testDTO.getLine1());
        return new ModelAndView("redirect:/").addObject(modelAndView);
    }
}

class TestDTO {
    private String line1;
    private String line2;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestDTO{");
        sb.append("line1='").append(line1).append('\'');
        sb.append(", line2='").append(line2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}