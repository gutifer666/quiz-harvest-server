package trade.javiergutierrez.quizharvestserver.contexts._shared.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository {
    List<Question> bySubjectAndEvaluation(Subject subject, Evaluation evaluation);

    void save(Question question);

    void delete(String id);
}
