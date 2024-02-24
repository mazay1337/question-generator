package proskyquestiongeneratorcourse2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import proskyquestiongeneratorcourse2.service.JavaQuestionService;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static proskyquestiongeneratorcourse2.TestConstants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    public void shouldAddQuestion() {
        out.add(QUESTION1, ANSWER1);

        assertTrue(out.getAll().contains(FULL_QUESTION1));
    }

    @Test
    public void shouldRemoveQuestion() {
        out.remove(QUESTION1, ANSWER1);

        assertFalse(out.getAll().contains(FULL_QUESTION1));
    }

    @Test
    public void shouldGetAllQuestion() {
        out.add(QUESTION1, ANSWER1);
        out.add(QUESTION2, ANSWER2);
        out.add(QUESTION3, ANSWER3);

        assertTrue(out.getAll().containsAll(List.of(FULL_QUESTION1, FULL_QUESTION2, FULL_QUESTION3)));
    }

    @Test
    public void shouldGetRandomQuestionTest() {
        out.add(QUESTION1, ANSWER1);
        out.add(QUESTION2, ANSWER2);

        Random random = mock(Random.class, withSettings().withoutAnnotations());
        when(random.nextInt(anyInt())).thenReturn(1);

        out.setRandom(random);
        assertEquals(FULL_QUESTION1, out.getRandomQuestion());
    }
}