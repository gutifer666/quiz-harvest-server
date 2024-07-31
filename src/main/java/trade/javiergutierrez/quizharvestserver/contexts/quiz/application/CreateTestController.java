package trade.javiergutierrez.quizharvestserver.contexts.quiz.application;

import org.springframework.stereotype.Controller;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Test;

@Controller
public interface CreateTestController {
  // Puerto que inicia la conversación con el caso de uso
  public Test create(Subject subject, Evaluation evaluation, int questions);
}
