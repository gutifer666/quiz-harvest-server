package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;

import java.util.List;

@Controller
public class TestMaker {

    private final QuestionRepository questionRepository;

    public TestMaker(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private List<Question> getQuestionRepository(Subject subject, Evaluation evaluation) {
        return questionRepository.bySubjectAndEvaluation(subject, evaluation);
    }

    public Test get(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        assert percentageOfQuestions > 0 && percentageOfQuestions <= 100 : "Percentage of questions must be between 1 and 100";
        List<Question> questionList = this.getQuestionRepository(subject, evaluation);
        if (questionList.isEmpty()) {
            throw new IllegalArgumentException("No questions found for the given criteria");
        }
        return new Test(questionList, percentageOfQuestions);
    }

}
