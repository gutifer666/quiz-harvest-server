package trade.javiergutierrez.quizharvestserver.contexts.quiz.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class Test {
    private List<Question> questions;
    private Subject subject;
    private Evaluation evaluation;

    public Test(List<Question> questions, int percentageOfQuestions) {
        assert !questions.isEmpty() : "Questions must not be empty";
        assert percentageOfQuestions > 0 && percentageOfQuestions <= 100 : "Percentage of questions must be between 1 and 100";
        this.subject = questions.get(0).getSubject();
        this.evaluation = questions.get(0).getEvaluation();
        this.questions = shuffleAndTrimQuestions(questions, percentageOfQuestions);
    }

    private List<Question> shuffleAndTrimQuestions(List<Question> questions, int percentageOfQuestions) {
        int testQuestions = (int) Math.ceil(questions.size() * (percentageOfQuestions / 100.0));
        List<Question> shuffledQuestions = new ArrayList<>(questions);
        Collections.shuffle(shuffledQuestions);
        return shuffledQuestions.subList(0, testQuestions);
}



}
