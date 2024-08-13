package trade.javiergutierrez.quizharvestserver.apps.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.application.TestMaker;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Test;

@Controller
public class QuizTestWebController {

    private final TestMaker testMaker;

    public QuizTestWebController(TestMaker testMaker) {
        this.testMaker = testMaker;
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
        Test test = testMaker.get(subjectEnum, evaluationEnum, questions);
        model.addAttribute("test", test);

        return "test-view";
    }
}
