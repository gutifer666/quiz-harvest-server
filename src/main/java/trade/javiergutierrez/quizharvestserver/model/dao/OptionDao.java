package trade.javiergutierrez.quizharvestserver.model.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "option_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionDao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "option_id")
  private Long id;

  @Column(name = "text_option", nullable = false)
  private String textOption;

  @Column(name = "is_correct", nullable = false)
  private boolean isCorrect;

  @ColumnDefault("false")
  @Column(name = "is_selected")
  private boolean isSelected;

  @ManyToOne
  @JoinColumn(name = "question_id", nullable = false)
  private QuestionDao question;
}
