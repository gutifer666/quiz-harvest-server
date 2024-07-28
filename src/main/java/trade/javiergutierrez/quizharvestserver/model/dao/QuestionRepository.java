package trade.javiergutierrez.quizharvestserver.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trade.javiergutierrez.quizharvestserver.model.Evaluation;
import trade.javiergutierrez.quizharvestserver.model.Subject;
import trade.javiergutierrez.quizharvestserver.model.dao.QuestionDao;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionDao, Long> {

  List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject);
}
