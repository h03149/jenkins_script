package org.sr4s.domain.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.GameResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ScoreRepositoryImpl implements ScoreRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ScoreDto> findCntryScoreList() {String sql =
            "WITH MaxUserScores AS (" +
                    "    SELECT" +
                    "        gr.user_seq," +
                    "        MAX(gr.score) AS max_score," +
                    "        MAX(gr.update_dt) as update_dt" +
                    "    FROM" +
                    "        game_result gr" +
                    "    WHERE" +
                    "        gr.deleted = false" +
                    "    AND" +
                    "        gr.create_dt between current_date and current_date+1" +
                    "    GROUP BY" +
                    "        gr.user_seq" +
                    ") " +
                    "SELECT" +
                    "    SUM(mus.max_score) AS score," +
                    "    um.cntry_cd " +
                    "FROM" +
                    "    user_master um " +
                    "JOIN" +
                    "    MaxUserScores mus ON um.user_seq = mus.user_seq " +
                    "WHERE" +
                    "    um.deleted = false " +
                    "GROUP BY" +
                    "    um.cntry_cd " +
                    "ORDER BY" +
                    "    score DESC, MAX(mus.update_dt) ASC";
        List<Object[]> result = entityManager.createNativeQuery(sql).getResultList();

        return result.stream()
                .map(record -> new ScoreDto(((BigDecimal)record[0]).intValue(), (String) record[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameResult> findAll() {
        return null;
    }

    @Override
    public List<GameResult> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<GameResult> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<GameResult> findAllById(Iterable<Long> longs) {
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
    public void delete(GameResult entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends GameResult> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends GameResult> S save(S entity) {
        return null;
    }

    @Override
    public <S extends GameResult> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<GameResult> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends GameResult> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends GameResult> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<GameResult> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public GameResult getOne(Long aLong) {
        return null;
    }

    @Override
    public GameResult getById(Long aLong) {
        return null;
    }

    @Override
    public GameResult getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends GameResult> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends GameResult> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends GameResult> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends GameResult> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends GameResult> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends GameResult> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends GameResult, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
