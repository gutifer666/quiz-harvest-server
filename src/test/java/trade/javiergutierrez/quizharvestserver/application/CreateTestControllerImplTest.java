package trade.javiergutierrez.quizharvestserver.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import trade.javiergutierrez.quizharvestserver.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.domain.Question;
import trade.javiergutierrez.quizharvestserver.domain.Subject;
import trade.javiergutierrez.quizharvestserver.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.domain.dao.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.utils.ListQuestionDaoToListQuestion;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class CreateTestControllerImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private ListQuestionDaoToListQuestion listQuestionDaoToListQuestion;

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

        // And a list of 2 questions from the database
        QuestionDao questionDao1 = new QuestionDao();
        QuestionDao questionDao2 = new QuestionDao();
        List<QuestionDao> questionDaoList = List.of(questionDao1, questionDao2);
        when(questionRepository.findByEvaluationAndSubject(evaluation, subject)).thenReturn(questionDaoList);

        // And a list of 2 questions
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = List.of(question1, question2);
        when(listQuestionDaoToListQuestion.convert(questionDaoList)).thenReturn(questionList);

        // When a test is created
        trade.javiergutierrez.quizharvestserver.domain.Test result = createTestControllerImpl.create(subject, evaluation, percentageOfQuestions);

        // Then the test contains all questions
        assertEquals(questionList, result.getQuestions());


    }

    @Test
    void    createReturnsOneQuestionWithPercentageOfQuestionsEqualTo50and2Questions() {
        // Given parameters
        Subject subject = Subject.DATABASES;
        Evaluation evaluation = Evaluation.SECOND;
        int percentageOfQuestions = 50;

        // And a list of 2 questions from the database
        QuestionDao questionDao1 = new QuestionDao();
        QuestionDao questionDao2 = new QuestionDao();
        List<QuestionDao> questionDaoList = List.of(questionDao1, questionDao2);
        when(questionRepository.findByEvaluationAndSubject(evaluation, subject)).thenReturn(questionDaoList);

        // And a list of 2 questions
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = List.of(question1, question2);
        when(listQuestionDaoToListQuestion.convert(questionDaoList)).thenReturn(questionList);

        // When a test is created
        trade.javiergutierrez.quizharvestserver.domain.Test result = createTestControllerImpl.create(subject, evaluation, percentageOfQuestions);

        // Then the test contains one question
        assertEquals(1, result.getQuestions().size());
    }
}
