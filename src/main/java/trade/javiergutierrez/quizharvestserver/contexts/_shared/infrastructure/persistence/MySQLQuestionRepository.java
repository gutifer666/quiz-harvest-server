package trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.*;

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

    @Override
    public void save(Question question) {
    String questionSql = "INSERT INTO question (id, text_question, subject, evaluation) VALUES (?, ?, ?, ?) " +
                         "ON DUPLICATE KEY UPDATE text_question = VALUES(text_question), subject = VALUES(subject), evaluation = VALUES(evaluation)";
    template.update(questionSql, question.getId(), question.getTextQuestion(), question.getSubject().toString(), question.getEvaluation().toString());

    String optionSql = "INSERT INTO option_entity (option_id, question_id, text_option, is_correct, is_selected) VALUES (?, ?, ?, ?, ?) " +
                       "ON DUPLICATE KEY UPDATE text_option = VALUES(text_option), is_correct = VALUES(is_correct), is_selected = VALUES(is_selected)";
    for (Option option : question.getOptions()) {
        template.update(optionSql, option.getId(), question.getId(), option.getTextOption(), option.isCorrect(), option.isSelected());
    }
}

    @Override
    public void delete(String id) {
        String optionSql = "DELETE FROM option_entity WHERE question_id = ?";
        template.update(optionSql, id);
        String questionSql = "DELETE FROM question WHERE id = ?";
        template.update(questionSql, id);
    }
}
