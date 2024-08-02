package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.OptionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.DataBaseRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestGetter {

    private final DataBaseRepository dataBaseRepository;


    public TestGetter(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public Test get(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        Test test;
        test = new Test(this.toQuestion(dataBaseRepository
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
