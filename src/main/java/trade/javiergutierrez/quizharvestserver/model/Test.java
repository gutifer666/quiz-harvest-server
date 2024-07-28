package trade.javiergutierrez.quizharvestserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Test {
  private List<Question> questions;
  private int testQuestions;

  public Test(List<Question> questions) {
    this.questions = questions;
    this.testQuestions = questions.size();
  }

}
