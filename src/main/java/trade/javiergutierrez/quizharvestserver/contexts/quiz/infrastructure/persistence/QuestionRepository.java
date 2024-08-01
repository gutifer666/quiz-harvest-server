package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.QuizRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;

import java.util.List;

public class QuestionRepository implements QuizRepository {
    private final DataBaseQuestionRepository dataBaseQuestionRepository;

    public QuestionRepository(DataBaseQuestionRepository dataBaseQuestionRepository) {
        this.dataBaseQuestionRepository = dataBaseQuestionRepository;
    }

    @Override
    public List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject) {

        return dataBaseQuestionRepository.findByEvaluationAndSubject(evaluation, subject);
    }
}
