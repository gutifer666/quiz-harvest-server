package trade.javiergutierrez.quizharvestserver.apps.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.management.application.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionService = new QuestionService(questionRepository);
    }

    @PostMapping
    public ResponseEntity<Void> createQuestion(@RequestBody Question question) {
        questionService.createQuestion(question);
        return ResponseEntity.ok().build();
    }
}
