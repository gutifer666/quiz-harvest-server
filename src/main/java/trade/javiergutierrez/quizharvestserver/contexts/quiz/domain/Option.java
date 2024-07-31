package trade.javiergutierrez.quizharvestserver.contexts.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
  private Long id;
  private String textOption;
  private boolean isCorrect;
  private boolean isSelected;

  public Option(long id, String textOption, boolean isCorrect) {
    this.id = id;
    this.textOption = textOption;
    this.isCorrect = isCorrect;
    this.isSelected = false;
  }
}
