package trade.javiergutierrez.quizharvestserver.contexts.management.application;

import org.springframework.stereotype.Service;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.QuestionRepository;
import trade.javiergutierrez.quizharvestserver.contexts._shared.infrastructure.persistence.MySQLQuestionRepository;

@Service
public class QuestionService {
    QuestionRepository questionRepository;

    public QuestionService(MySQLQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Question question) {
        questionRepository.save(question);
    }
}
