package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.*;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.OptionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.QuizRepositoryMySql;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestGetter {

    private final QuizRepositoryMySql quizRepositoryMySql;

    public TestGetter(QuizRepositoryMySql quizRepositoryMySql) {
        this.quizRepositoryMySql = quizRepositoryMySql;
    }

    public Test get(Subject subject, Evaluation evaluation, int percentageOfQuestions) {
        List<QuestionDao> questionDaos = quizRepositoryMySql.findByEvaluationAndSubject(evaluation, subject);
        List<Question> questions = toQuestion(questionDaos);
        Test test = new Test(questions);
        test.configTest(percentageOfQuestions);
        return test;
    }

    public List<Question> toQuestion(List<QuestionDao> questionDaos) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDao questionDao : questionDaos) {
            questions.add(new Question(
                questionDao.getId(),
                questionDao.getTextQuestion(),
                toOptionList(questionDao.getOptions()),
                questionDao.getSubject(),
                questionDao.getEvaluation()
            ));
        }
        return questions;
    }

    private List<Option> toOptionList(List<OptionDao> optionEntityList) {
        if (optionEntityList == null) {
            return null;
        }
        List<Option> options = new ArrayList<>();
        for (OptionDao optionEntity : optionEntityList) {
            options.add(new Option(
                optionEntity.getId(),
                optionEntity.getTextOption(),
                optionEntity.isCorrect()
            ));
        }
        return options;
    }
}
