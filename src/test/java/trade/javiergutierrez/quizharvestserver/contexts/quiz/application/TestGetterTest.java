package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.MySQLQuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Option;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class TestGetterTest {

    @Mock
    private MySQLQuestionRepository mySQLQuestionRepository;

    @InjectMocks
    private TestGetter testGetter;
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void    getReturnsAllQuestionsWithPercentageOfQuestionsEqualTo100and2QuestionsWith4optionsForQuestion(){
        // Given
        Subject subject = Subject.DATABASES;
        Evaluation evaluation = Evaluation.SECOND;
        int percentageOfQuestions = 100;

        Question question1 = new Question();
        question1.setId(1L);
        question1.setTextQuestion("Question 1");
        question1.setSubject(Subject.DATABASES);
        question1.setEvaluation(Evaluation.SECOND);
        question1.setOptions(List.of(
            new Option(1L, "Option 1", false, false),
            new Option(2L, "Option 2", true, false),
            new Option(3L, "Option 3", false, false),
            new Option(4L, "Option 4", false, false)
        ));

        Question question2 = new Question();
        question2.setId(2L);
        question2.setTextQuestion("Question 2");
        question2.setSubject(Subject.DATABASES);
        question2.setEvaluation(Evaluation.SECOND);
        question2.setOptions(List.of(
            new Option(5L, "Option 5", false, false),
            new Option(6L, "Option 6", true, false),
            new Option(7L, "Option 7", false, false),
            new Option(8L, "Option 8", false, false)
        ));

        List<Question> questionList = List.of(question1, question2);
        when(mySQLQuestionRepository.bySubjectAndEvaluation(subject, evaluation)).thenReturn(questionList);

        // When a test is created
        trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.
            Test test = testGetter.get(subject, evaluation, percentageOfQuestions);

        // Then the test contains 2 questions
        assertEquals(2, test.getQuestions().size());

        // And the first question contains 4 options
        assertEquals(4, test.getQuestions().get(0).getOptions().size());

        // And the second question contains 4 options
        assertEquals(4, test.getQuestions().get(1).getOptions().size());
    }
    @Test
    void    getReturnsAssertionErrorWhenPercentageOfQuestionsIsLessThan1(){
        // Given
        Subject subject = Subject.DATABASES;
        Evaluation evaluation = Evaluation.SECOND;
        int percentageOfQuestions = 0;

        // When a test is created
        // Then an assertion error is thrown
        assertThrows(AssertionError.class, () -> testGetter.get(subject, evaluation, percentageOfQuestions));
    }
    @Test
    void    getReturnsAssertionErrorWhenPercentageOfQuestionsIsGreaterThan100(){
        // Given
        Subject subject = Subject.DATABASES;
        Evaluation evaluation = Evaluation.SECOND;
        int percentageOfQuestions = 101;

        // When a test is created
        // Then an assertion error is thrown
        assertThrows(AssertionError.class, () -> testGetter.get(subject, evaluation, percentageOfQuestions));
    }
}
