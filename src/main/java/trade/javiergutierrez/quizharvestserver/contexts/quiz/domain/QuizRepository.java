package trade.javiergutierrez.quizharvestserver.contexts.quiz.domain;

import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;

import java.util.List;

public interface QuizRepository {
    List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject);
}
