package trade.javiergutierrez.quizharvestserver.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trade.javiergutierrez.quizharvestserver.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.domain.Subject;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionDao, Long> {

  List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject);
}
