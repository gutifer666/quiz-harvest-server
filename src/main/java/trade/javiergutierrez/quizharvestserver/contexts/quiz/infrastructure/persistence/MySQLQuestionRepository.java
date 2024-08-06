package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;

import java.util.List;

@Repository
public class MySQLQuestionRepository implements QuestionRepository {
    @Override
    public List<Question> bySubjectAndEvaluation(Subject subject, Evaluation evaluation) {
        return null;
    }
}
