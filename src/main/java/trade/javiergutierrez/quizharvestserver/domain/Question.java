package trade.javiergutierrez.quizharvestserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  private Long id;
  private String textQuestion;
  private List<Option> options;
  private Subject subject;
  private Evaluation evaluation;

}
