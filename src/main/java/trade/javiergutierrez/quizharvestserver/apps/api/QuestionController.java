package trade.javiergutierrez.quizharvestserver.apps.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure.persistence.MySQLQuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.management.application.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(MySQLQuestionRepository questionRepository) {
        this.questionService = new QuestionService(questionRepository);
    }

    @PostMapping
    public ResponseEntity<Void> createQuestion(@RequestBody Question question) {
        questionService.createQuestion(question);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{subject}/{evaluation}")
    public ResponseEntity<List<Question>> readQuestionsBySubjectAndEvaluation(@PathVariable String subject, @PathVariable String evaluation) {
        List<Question> questions = questionService.readQuestionsBySubjectAndEvaluation(subject, evaluation);
        return ResponseEntity.ok(questions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }
}
