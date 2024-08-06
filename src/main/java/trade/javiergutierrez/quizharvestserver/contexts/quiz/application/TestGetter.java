package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.MySQLQuestionRepository;

import java.util.List;

@Controller
public class TestGetter {

    private final MySQLQuestionRepository mySQLQuestionRepository;

    public TestGetter(MySQLQuestionRepository mySQLQuestionRepository) {
        this.mySQLQuestionRepository = mySQLQuestionRepository;
    }

    public Test get(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        List<Question> questions = mySQLQuestionRepository.bySubjectAndEvaluation(subject, evaluation);
        Test test = new Test(questions);
        test.configTest(percentageOfQuestions);
        return test;
    }

}
