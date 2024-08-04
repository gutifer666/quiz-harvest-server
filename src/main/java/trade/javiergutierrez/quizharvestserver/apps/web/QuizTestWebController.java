package trade.javiergutierrez.quizharvestserver.apps.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizTestWebController {
    @GetMapping("/configure")
    public String configure() {
        return "configuration-test-view";
    }
}
