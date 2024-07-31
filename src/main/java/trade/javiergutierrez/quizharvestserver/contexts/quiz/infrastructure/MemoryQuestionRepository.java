package trade.javiergutierrez.quizharvestserver.contexts.quiz.infrastructure;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Evaluation;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.Subject;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionDao;
import trade.javiergutierrez.quizharvestserver.contexts.quiz.domain.dao.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MemoryQuestionRepository implements QuestionRepository {
    private final List<QuestionDao> questionDaos;

    public MemoryQuestionRepository(List<QuestionDao> questionDaos) {
        this.questionDaos = questionDaos;
    }

    @Override
    public List<QuestionDao> findByEvaluationAndSubject(Evaluation evaluation, Subject subject) {
        for (QuestionDao questionDao : questionDaos) {
            if (questionDao.getEvaluation().equals(evaluation) && questionDao.getSubject().equals(subject)) {
                return List.of(questionDao);
            }
        }
        return List.of();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends QuestionDao> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends QuestionDao> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<QuestionDao> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public QuestionDao getOne(Long aLong) {
        return null;
    }

    @Override
    public QuestionDao getById(Long aLong) {
        return null;
    }

    @Override
    public QuestionDao getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends QuestionDao> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends QuestionDao> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends QuestionDao> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends QuestionDao> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends QuestionDao> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends QuestionDao> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends QuestionDao, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends QuestionDao> S save(S entity) {
        return null;
    }

    @Override
    public <S extends QuestionDao> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<QuestionDao> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<QuestionDao> findAll() {
        return null;
    }

    @Override
    public List<QuestionDao> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(QuestionDao entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends QuestionDao> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<QuestionDao> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<QuestionDao> findAll(Pageable pageable) {
        return null;
    }
}
