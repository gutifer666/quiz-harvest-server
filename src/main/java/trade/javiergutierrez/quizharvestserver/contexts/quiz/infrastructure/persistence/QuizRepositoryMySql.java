package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.QuizRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;

import java.util.List;

public interface QuizRepositoryMySql extends JpaRepository<QuestionDao, Long>, QuizRepository {

  List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject);
}
