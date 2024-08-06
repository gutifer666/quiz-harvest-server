package trade.javiergutierrez.quizharvestserver.contexts.quiz.domain;

import java.util.List;

public interface QuestionRepository {
    List<Question> findQuestions(Subject subject, Evaluation evaluation);
}
