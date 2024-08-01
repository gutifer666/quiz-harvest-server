package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.DataBaseQuestionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class CreateTestControllerImplTest {

    @Mock
    private DataBaseQuestionRepository dataBaseQuestionRepository;

    @InjectMocks
    private CreateTestControllerImpl createTestControllerImpl;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void    createReturnsAllQuestionsWithPercentageOfQuestionsEqualTo100and2Questions() {
        // Given parameters
        Subject subject = Subject.DATABASES;
        Evaluation evaluation = Evaluation.SECOND;
        int percentageOfQuestions = 100;

        // And a list of 2 questionsDao from the database
        QuestionDao questionDao1 = new QuestionDao();
        QuestionDao questionDao2 = new QuestionDao();
        List<QuestionDao> questionDaoList = List.of(questionDao1, questionDao2);
        when(dataBaseQuestionRepository.findByEvaluationAndSubject(evaluation, subject)).thenReturn(questionDaoList);

        // When a test is created
        trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.
            Test test = createTestControllerImpl.create(subject, evaluation, percentageOfQuestions);

        // Then the test contains 2 questions
        assertEquals(2, test.getQuestions().size());

    }
}
