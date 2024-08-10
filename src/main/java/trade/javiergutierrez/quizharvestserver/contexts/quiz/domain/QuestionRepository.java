package trade.javiergutierrez.quizharvestserver.contexts.quiz.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository {
    List<Question> bySubjectAndEvaluation(Subject subject, Evaluation evaluation);
}
