package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure.persistence;

import org.springframework.jdbc.core.RowMapper;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Option;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getLong("id"));
        question.setTextQuestion(rs.getString("text_question"));
        question.setSubject(Subject.valueOf(rs.getString("subject")));
        question.setEvaluation(Evaluation.valueOf(rs.getString("evaluation")));

        // Solo se agrega una opción para la fila actual
        List<Option> options = new ArrayList<>();
        Option option = new Option();
        option.setId(rs.getLong("option_id"));
        option.setTextOption(rs.getString("text_option"));
        option.setCorrect(rs.getBoolean("is_correct"));
        option.setSelected(rs.getBoolean("is_selected"));
        options.add(option);

        question.setOptions(options);
        return question;
    }
}
