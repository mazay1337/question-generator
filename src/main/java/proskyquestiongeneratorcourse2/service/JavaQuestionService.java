package proskyquestiongeneratorcourse2.service;


import org.springframework.stereotype.Service;
import proskyquestiongeneratorcourse2.question.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private Random random = new Random();

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public boolean add(String question, String answer) {
        return questions.add(new Question(question, answer));
    }

    @Override
    public boolean remove(String question, String answer) {
        return questions.remove(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public int getSize() {
        return questions.size();
    }
}