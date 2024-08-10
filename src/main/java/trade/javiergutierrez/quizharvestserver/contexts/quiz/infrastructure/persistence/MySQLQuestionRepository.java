package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<Question> rawQuestions = template.query(sql, new QuestionMapper(), subject.toString(), evaluation.toString());

        // Aquí agrupamos las preguntas por su ID y nos aseguramos de no duplicar las opciones
        Map<Long, Question> questionMap = new HashMap<>();
        for (Question question : rawQuestions) {
            if (!questionMap.containsKey(question.getId())) {
                questionMap.put(question.getId(), question);
            } else {
                Question existingQuestion = questionMap.get(question.getId());
                existingQuestion.getOptions().addAll(question.getOptions());
            }
        }

        // Devolvemos solo las preguntas con las opciones correctamente asignadas
        return new ArrayList<>(questionMap.values());
    }
}
