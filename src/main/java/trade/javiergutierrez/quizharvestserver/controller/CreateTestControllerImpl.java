package trade.javiergutierrez.quizharvestserver.controller;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.model.*;
import trade.javiergutierrez.quizharvestserver.model.dao.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.utils.ListQuestionDaoToListQuestion;

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
