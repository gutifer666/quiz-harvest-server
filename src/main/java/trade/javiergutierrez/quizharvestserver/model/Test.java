package trade.javiergutierrez.quizharvestserver.model;

import lombok.AllArgsConstructor;
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

    public Test(List<Question> questions) {
        this.questions = questions;
        this.subject = questions.get(0).getSubject();
        this.evaluation = questions.get(0).getEvaluation();
        this.percentageOfQuestions = 100;
        this.testQuestions = questions.size();
    }

    public void configTest(int percentageOfQuestions) {
        assert percentageOfQuestions > 0 && percentageOfQuestions <= 100;
        this.percentageOfQuestions = percentageOfQuestions;
        this.testQuestions = (int) Math.ceil(questions.size() * (percentageOfQuestions / 100.0));
        this.questions = questions.subList(0, testQuestions);

    }

}
