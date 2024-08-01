package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.OptionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.MemoryDataBaseQuestionRepositoryImpl;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.DataBaseQuestionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateTestControllerImpl implements CreateTestController {

    private final DataBaseQuestionRepository dataBaseQuestionRepository;

    public CreateTestControllerImpl(DataBaseQuestionRepository dataBaseQuestionRepository) {

        this.dataBaseQuestionRepository = dataBaseQuestionRepository;
    }

    @Override
    public Test create(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        Test test;
        test = new Test(this.toQuestion(dataBaseQuestionRepository
                .findByEvaluationAndSubject(evaluation, subject)));
        test.configTest(percentageOfQuestions);
        return test;
    }
    public List<Question> toQuestion(List<QuestionDao> questionDaos) {
        List<Question> questions;
        questions = questionDaos.stream().map(questionDao -> new Question(questionDao.getId(), questionDao.getTextQuestion(), toOptionList(questionDao.getOptions()), questionDao.getSubject(), questionDao.getEvaluation())).toList();
        return questions;
    }

    private List<Option> toOptionList(List<OptionDao> optionEntityList) {
        if (optionEntityList == null) {
            return null;
        }
        List<Option> options = new ArrayList<>();
        for (OptionDao optionEntity : optionEntityList) {
            options.add(new Option(optionEntity.getId(), optionEntity.getTextOption(), optionEntity.isCorrect()));
        }
        return options;
    }
}
