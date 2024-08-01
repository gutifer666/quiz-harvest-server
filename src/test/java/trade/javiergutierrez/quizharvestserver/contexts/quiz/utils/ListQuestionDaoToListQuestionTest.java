package trade.javiergutierrez.quizharvestserver.contexts.quiz.utils;

import org.junit.jupiter.api.Test;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListQuestionDaoToListQuestionTest {

    private final ListQuestionDaoToListQuestion listQuestionDaoToListQuestion = new ListQuestionDaoToListQuestion();

    @Test
    void convertReturnsListOfQuestions() {
        // Given a list of questionDaos
        QuestionDao questionDao = new QuestionDao();
        List<QuestionDao> questionDaos = List.of(questionDao, questionDao);
        // When the list is converted
        List<Question> questions = listQuestionDaoToListQuestion.convert(questionDaos);
        // Then a list of questions is returned
        assertEquals(2, questions.size());
    }
}
