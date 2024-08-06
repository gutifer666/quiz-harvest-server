package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;

import java.util.List;

@Repository
public class MySQLQuestionRepository implements QuestionRepository {
    private final JdbcTemplate template;

    public MySQLQuestionRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Question> bySubjectAndEvaluation(Subject subject, Evaluation evaluation) {

        String sql = "SELECT * " +
                     "FROM question " +
                     "LEFT JOIN option_entity ON question.id = option_entity.question_id " +
                     "WHERE subject = ? AND evaluation = ?";

        return template.query(sql, new QuestionMapper(), subject.toString(), evaluation.toString());
    }
}
