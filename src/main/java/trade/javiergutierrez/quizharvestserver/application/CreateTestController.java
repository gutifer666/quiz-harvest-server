package trade.javiergutierrez.quizharvestserver.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.domain.Subject;
import trade.javiergutierrez.quizharvestserver.domain.Test;

@Controller
public interface CreateTestController {
  // Puerto que inicia la conversación con el caso de uso
  public Test create(Subject subject, Evaluation evaluation, int questions);
}
