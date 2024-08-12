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
        assert percentageOfQuestions > 0 && percentageOfQuestions <= 100 : "Percentage of questions must be between 1 and 100";
        List<Question> questions = questionRepository.bySubjectAndEvaluation(subject, evaluation);
        //test.configTest(percentageOfQuestions);
        return new Test(questions, percentageOfQuestions);
    }

}
