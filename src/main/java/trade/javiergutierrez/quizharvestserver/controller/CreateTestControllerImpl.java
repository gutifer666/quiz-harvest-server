package trade.javiergutierrez.quizharvestserver.controller;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.model.*;
import trade.javiergutierrez.quizharvestserver.model.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.model.dao.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.utils.ListQuestionDaoToListQuestion;

import java.util.List;

@Controller
public class CreateTestControllerImpl implements CreateTestController {

  private List<QuestionDao> questionsDao;
  private QuestionRepository questionRepository;
  private ListQuestionDaoToListQuestion listQuestionDaoToListQuestion;

  public CreateTestControllerImpl(QuestionRepository questionRepository, ListQuestionDaoToListQuestion listQuestionEntityToTest) {

    this.questionRepository = questionRepository;
    this.listQuestionDaoToListQuestion = listQuestionEntityToTest;
  }

  @Override
  public Test create(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
    Test test = new Test();
    this.questionsDao = questionRepository.findByEvaluationAndSubject(evaluation, subject);
    test = new Test(listQuestionDaoToListQuestion
                    .convert(questionRepository
                             .findByEvaluationAndSubject(evaluation, subject)));
    return test;
  }

}
