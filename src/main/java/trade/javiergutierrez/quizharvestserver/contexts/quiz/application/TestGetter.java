package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.MySQLQuestionRepository;

import java.util.List;

@Controller
public class TestGetter {

    private final QuestionRepository questionRepository;

    public TestGetter(MySQLQuestionRepository mySQLQuestionRepository) {
        this.questionRepository = mySQLQuestionRepository;
    }

    public Test get(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        List<Question> questions = questionRepository.findQuestions(subject, evaluation);
        Test test = new Test(questions);
        test.configTest(percentageOfQuestions);
        return test;
    }

}
