package proskyquestiongeneratorcourse2.service;

import proskyquestiongeneratorcourse2.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}