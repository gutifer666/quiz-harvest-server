package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.OptionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.MemoryQuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.utils.ListQuestionDaoToListQuestion;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateTestControllerImpl implements CreateTestController {

    private final QuestionRepository questionRepository;
    private final MemoryQuestionRepository memoryQuestionRepository;
    private final ListQuestionDaoToListQuestion listQuestionDaoToListQuestion;

    public CreateTestControllerImpl(QuestionRepository questionRepository, MemoryQuestionRepository memoryQuestionRepository, ListQuestionDaoToListQuestion listQuestionDaoToListQuestion) {

        this.questionRepository = questionRepository;
        this.memoryQuestionRepository = memoryQuestionRepository;
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
    public List<Question> toQuestion(List<QuestionDao> questionDaos) {
        List<Question> questions;
        questions = questionDaos.stream().map(questionDao -> {
            return new Question(questionDao.getId(), questionDao.getTextQuestion(), toOptionList(questionDao.getOptions()), questionDao.getSubject(), questionDao.getEvaluation());
        }).toList();
        return questions;
    }

    private List<Option> toOptionList(List<OptionDao> optionEntityList) {
        if (optionEntityList == null) {
            return new ArrayList<>();
        }
        List<Option> options = new ArrayList<>();
        for (OptionDao optionEntity : optionEntityList) {
            options.add(new Option(optionEntity.getId(), optionEntity.getTextOption(), optionEntity.isCorrect()));
        }
        return options;
    }
}
