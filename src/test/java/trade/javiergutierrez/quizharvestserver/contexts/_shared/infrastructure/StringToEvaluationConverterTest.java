package trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure;

import org.junit.jupiter.api.Test;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;

import static org.junit.jupiter.api.Assertions.*;

class StringToEvaluationConverterTest {
    @Test
    void testStringToEvaluationConverter() {
        StringToEvaluationConverter converter = new StringToEvaluationConverter();
        assertEquals(Evaluation.SECOND, converter.convert("second"));
    }
}
