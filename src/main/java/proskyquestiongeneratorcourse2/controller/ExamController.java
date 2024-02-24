package proskyquestiongeneratorcourse2.controller;

import org.springframework.web.bind.annotation.RestController;
import proskyquestiongeneratorcourse2.service.ExaminerService;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }
}