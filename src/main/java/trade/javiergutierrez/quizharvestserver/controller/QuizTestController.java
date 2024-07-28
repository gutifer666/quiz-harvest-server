package trade.javiergutierrez.quizharvestserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import trade.javiergutierrez.quizharvestserver.model.Evaluation;
import trade.javiergutierrez.quizharvestserver.model.Subject;
import trade.javiergutierrez.quizharvestserver.model.Test;

@RestController
public class QuizTestController {

  private CreateTestController testController;

  public QuizTestController(CreateTestController testService) {
    this.testController = testService;
  }

  @GetMapping("/create-test/{subject}/{evaluation}/{questions}")
  public ResponseEntity<Test> create(@PathVariable Subject subject, @PathVariable Evaluation evaluation, @PathVariable int questions) {
    // Adaptador que convierte las @PathVariable en tipos de datos que el servicio pueda entender y ejercitar el puerto
    return ResponseEntity.ok(testController.create(subject, evaluation, questions));
  }
}
