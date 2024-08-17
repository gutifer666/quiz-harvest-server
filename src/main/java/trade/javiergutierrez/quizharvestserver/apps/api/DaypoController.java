package trade.javiergutierrez.quizharvestserver.apps.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import trade.javiergutierrez.quizharvestserver.contexts.management.application.CreateQuestionsFromDaypo;

@RestController
public class DaypoController {
    private final CreateQuestionsFromDaypo createQuestionsFromDaypo;

    public DaypoController(CreateQuestionsFromDaypo createQuestionsFromDaypo) {
        this.createQuestionsFromDaypo = createQuestionsFromDaypo;
    }

    @PostMapping(value = "/upload-file")
    public ResponseEntity<Void> uploadDaypoFile(@RequestParam("file") MultipartFile file) {
        createQuestionsFromDaypo.execute(file);
        return ResponseEntity.ok().build();
    }
}
