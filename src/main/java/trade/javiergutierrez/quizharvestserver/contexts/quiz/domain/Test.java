package trade.javiergutierrez.quizharvestserver.contexts.quiz.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Test {
    private List<Question> questions;
    private Subject subject;
    private Evaluation evaluation;
    private int percentageOfQuestions;
    private int testQuestions;

    public Test(List<Question> questions, int percentageOfQuestions) {
        assert percentageOfQuestions > 0 && percentageOfQuestions <= 100 : "Percentage of questions must be between 1 and 100";
        this.questions = questions;
        this.subject = questions.get(0).getSubject();
        this.evaluation = questions.get(0).getEvaluation();
        this.percentageOfQuestions = percentageOfQuestions;
        this.testQuestions = (int) Math.ceil(questions.size() * (percentageOfQuestions / 100.0));
    }

}
