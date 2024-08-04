package trade.javiergutierrez.quizharvestserver.apps.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.application.TestGetter;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Test;

@Controller
public class QuizTestWebController {

    private final TestGetter testGetter;

    public QuizTestWebController(TestGetter testGetter) {
        this.testGetter = testGetter;
    }

    @GetMapping("web/configure")
    public String runConfigure() {
        return "configuration-test-view";
    }

    @GetMapping("web/test")
    public String runTest(@RequestParam(name="subject") String subject ,
                          @RequestParam(name="evaluation") String evaluation,
                          @RequestParam(name="percentageOfQuestions") int questions,
                          Model model) {

        Subject subjectEnum = Subject.valueOf(subject.toUpperCase());
        Evaluation evaluationEnum = Evaluation.valueOf(evaluation.toUpperCase());
        Test test = testGetter.get(subjectEnum, evaluationEnum, questions);
        model.addAttribute("test", test);

        return "test-view";
    }
}
