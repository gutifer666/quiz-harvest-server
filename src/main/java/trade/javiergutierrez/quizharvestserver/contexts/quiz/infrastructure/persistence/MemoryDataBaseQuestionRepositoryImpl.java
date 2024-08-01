package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.QuizRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;

import java.util.List;

public class MemoryDataBaseQuestionRepositoryImpl implements QuizRepository {
    private final List<QuestionDao> questionDaos;

    public MemoryDataBaseQuestionRepositoryImpl(List<QuestionDao> questionDaos) {
        this.questionDaos = questionDaos;
    }

    @Override
    public List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject) {
        for (QuestionDao questionDao : questionDaos) {
            if (questionDao.getEvaluation().equals(evaluation) && questionDao.getSubject().equals(subject)) {
                return List.of(questionDao);
            }
        }
        return List.of();
    }
}
