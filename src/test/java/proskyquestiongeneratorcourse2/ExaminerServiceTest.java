package proskyquestiongeneratorcourse2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proskyquestiongeneratorcourse2.service.ExaminerServiceImpl;
import proskyquestiongeneratorcourse2.service.QuestionService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static proskyquestiongeneratorcourse2.TestConstants.FULL_QUESTION1;
import static proskyquestiongeneratorcourse2.TestConstants.TEST_QUESTIONS2;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    QuestionService mock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void getQuestionsTest() {

        when(mock.getSize()).thenReturn(1);

        when(mock.getRandomQuestion()).thenReturn(FULL_QUESTION1);

        assertEquals(TEST_QUESTIONS2, out.getQuestions(1));
    }
}