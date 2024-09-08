package trade.javiergutierrez.quizharvestserver.apps.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.application.TestMaker;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Test;
import trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure.persistence.MySQLQuestionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuizTestController {

    private final TestMaker testMaker;

    public QuizTestController(MySQLQuestionRepository questionRepository) {
        this.testMaker = new TestMaker(questionRepository);
    }

    @GetMapping("/test/{subject}/{evaluation}/{questions}")
    public ResponseEntity<Test> run(@PathVariable Subject subject, @PathVariable Evaluation evaluation, @PathVariable int questions) {
        return ResponseEntity.ok(testMaker.get(subject, evaluation, questions));
    }
}
