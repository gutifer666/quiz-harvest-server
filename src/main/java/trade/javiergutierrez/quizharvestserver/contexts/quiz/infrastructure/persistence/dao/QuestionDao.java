package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "question")
public class QuestionDao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "text_question", nullable = false)
  private String textQuestion;

  @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OptionDao> options;

  @Enumerated(EnumType.STRING)
  private Subject subject;

  @Enumerated(EnumType.STRING)
  private Evaluation evaluation;
}
