package proskyquestiongeneratorcourse2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionsException extends RuntimeException {
    public QuestionsException(int amount, int size) {
        super(String.format("Запрошенная сумма %d превышает текущий размер %d", amount , size));
    }
}