package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Test;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.utils.ListQuestionDaoToListQuestion;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionRepository;

@Controller
public class CreateTestControllerImpl implements CreateTestController {

    private final QuestionRepository questionRepository;
    private final ListQuestionDaoToListQuestion listQuestionDaoToListQuestion;

    public CreateTestControllerImpl(QuestionRepository questionRepository, ListQuestionDaoToListQuestion listQuestionDaoToListQuestion) {

        this.questionRepository = questionRepository;
        this.listQuestionDaoToListQuestion = listQuestionDaoToListQuestion;

    }

    @Override
    public Test create(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        Test test;
        test = new Test(listQuestionDaoToListQuestion
            .convert(questionRepository
                .findByEvaluationAndSubject(evaluation, subject)));
        test.configTest(percentageOfQuestions);
        return test;
    }

}
