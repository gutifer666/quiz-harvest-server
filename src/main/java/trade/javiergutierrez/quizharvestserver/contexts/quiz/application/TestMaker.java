package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.MySQLQuestionRepository;

import java.util.List;

@Controller
public class TestMaker {

    private final QuestionRepository questionRepository;

    public TestMaker(MySQLQuestionRepository mySQLQuestionRepository) {
        this.questionRepository = mySQLQuestionRepository;
    }

    private List<Question> getQuestionRepository(Subject subject, Evaluation evaluation) {
        return questionRepository.bySubjectAndEvaluation(subject, evaluation);
    }

    public Test get(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        assert percentageOfQuestions > 0 && percentageOfQuestions <= 100 : "Percentage of questions must be between 1 and 100";
        return new Test(this.getQuestionRepository(subject, evaluation), percentageOfQuestions);
    }

}
