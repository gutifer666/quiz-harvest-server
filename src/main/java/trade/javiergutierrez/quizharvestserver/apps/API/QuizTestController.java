package trade.javiergutierrez.quizharvestserver.apps.API;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.application.TestGetter;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Test;

@RestController
public class QuizTestController {

    private final TestGetter testGetter;

    public QuizTestController(TestGetter testGetter) {
        this.testGetter = testGetter;
    }

    @GetMapping("/create-test/{subject}/{evaluation}/{questions}")
    public ResponseEntity<Test> get(@PathVariable Subject subject, @PathVariable Evaluation evaluation, @PathVariable int questions) {
        return ResponseEntity.ok(testGetter.get(subject, evaluation, questions));
    }
}
