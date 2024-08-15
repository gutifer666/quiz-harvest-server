package trade.javiergutierrez.quizharvestserver.contexts.management.application;

import org.springframework.stereotype.Service;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.Question;
import trade.javiergutierrez.quizharvestserver.contexts._shared.domain.QuestionRepository;

@Service
public class QuestionService {
    QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Question question) {
        questionRepository.save(question);
    }
}
