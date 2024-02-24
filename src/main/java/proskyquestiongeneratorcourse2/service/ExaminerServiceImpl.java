package proskyquestiongeneratorcourse2.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import proskyquestiongeneratorcourse2.exceptions.QuestionsException;
import proskyquestiongeneratorcourse2.question.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private static final Logger logger = LoggerFactory.getLogger(ExaminerServiceImpl.class);

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getSize();
        if (amount <= 0 || size < amount) {
            logger.error("Неправильная запрошенная сумма" + size);
            throw new QuestionsException(amount, size);
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        logger.info("Вопросы были получены" + questions);
        return questions;
    }
}