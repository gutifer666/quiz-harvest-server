package trade.javiergutierrez.quizharvestserver.contexts.management.domain;

import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Option;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapper {
    public static Question  map(trade.javiergutierrez.quizharvestserver.contexts.management.domain.Question questionManagement) {
        Long id = questionManagement.getId();
        String textQuestion = questionManagement.getQuestion();
        List<Option> options = getOptions();
        Subject subject = getSubject();
        Evaluation evaluation = getEvaluation();
        return new Question(id, textQuestion, options, subject, evaluation);
    }

    private static List<Option> getOptions() {
       List<Option> options = new ArrayList<>();
       for (int i = 0; i < 4; i++) {
           options.set(i, new Option(i+1,
                               getOptionText(i),
                                false));
       }
        return options;
    }
    // TODO: Implement this method
    private static String getOptionText(int i) {
        return "Option " + i;
    }
    // TODO: Implement this method
    private static Subject getSubject() {
        return Subject.DATABASES;
    }
    // TODO: Implement this method
    private static Evaluation getEvaluation() {
        return Evaluation.FIRST;
    }
}
