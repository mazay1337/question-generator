package proskyquestiongeneratorcourse2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proskyquestiongeneratorcourse2.question.Question;
import proskyquestiongeneratorcourse2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void addQuestion(@RequestParam String question,
                            @RequestParam String answer) {
        service.add(question, answer);
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam String question,
                               @RequestParam String answer) {
        service.remove(question, answer);
    }

    @GetMapping("/find")
    public Collection<Question> getAllQuestion() {
        return service.getAll();
    }
}