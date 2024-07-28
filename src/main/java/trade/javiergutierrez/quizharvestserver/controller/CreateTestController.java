package trade.javiergutierrez.quizharvestserver.controller;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.model.Evaluation;
import trade.javiergutierrez.quizharvestserver.model.Subject;
import trade.javiergutierrez.quizharvestserver.model.Test;

@Controller
public interface CreateTestController {
  // Puerto que inicia la conversación con el caso de uso
  public Test create(Subject subject, Evaluation evaluation, int questions);
}
