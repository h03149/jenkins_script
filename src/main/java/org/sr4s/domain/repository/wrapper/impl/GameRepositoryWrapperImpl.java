package org.sr4s.domain.repository.wrapper.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.sr4s.domain.dto.QScoreDto;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.QGameResult;
import org.sr4s.domain.entity.QUserMaster;
import org.sr4s.domain.repository.wrapper.GameRepositoryWrapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class GameRepositoryWrapperImpl extends QuerydslRepositorySupport implements GameRepositoryWrapper {
    private final JPAQueryFactory query;

    QGameResult game = QGameResult.gameResult;
    QUserMaster user = QUserMaster.userMaster;
    LocalDate today = ZonedDateTime.now(ZoneId.of("UTC")).toLocalDate();

    public GameRepositoryWrapperImpl(JPAQueryFactory queryFactory) {
        super(QGameResult.class);
        this.query = queryFactory;
    }
    @Override
    public List<ScoreDto> findCntryScoreList() {
        List<ScoreDto> result = query.select(new QScoreDto(user.cntryCd, game.score.sum()))
                .from(game)
                .leftJoin(game.user, user)
                .where(game.createDt.between(today.atStartOfDay(), today.plusDays(1).atStartOfDay()))
                .groupBy(user.cntryCd)
                .orderBy(game.score.sum().desc(), game.updateDt.max().asc())
                .fetch();
        return result;
    }

    /*@Override
    public List<ScoreDto> findCntryScoreList() {
        List<ScoreDto> result = findAllCntryScoreList();
        result.stream().limit(8);
        return result;
    }*/

    @Override
    public ScoreDto findCntryScore(String cntryCd) {
        ScoreDto result = query.select(new QScoreDto(user.cntryCd, game.score.max()))
                .from(game)
                .leftJoin(game.user, user)
                .where(isCntryCd(cntryCd))
                .groupBy(user.cntryCd)
                .fetchOne();
        return result;
    }

    @Override
    public List<ScoreDto> findScoreList() {
        List<ScoreDto> result = query.select(new QScoreDto(user.cntryCd, game.score, user.userNm, user.userSeq))
                .from(game)
                .leftJoin(game.user, user)
                .where(game.createDt.between(today.atStartOfDay(), today.plusDays(1).atStartOfDay()))
                .orderBy(game.score.desc(), game.createDt.asc())
                .limit(101)
                .fetch();
        return result;
    }

    @Override
    public List<ScoreDto> findUserScore(String cntryCd, Long userSeq) {
        List<ScoreDto> result = query.select(new QScoreDto(game.score.max(), user.userNm, user.userSeq))
                .from(game)
                .leftJoin(game.user, user)
                .groupBy(user.userSeq)
                .where(isCntryCd(cntryCd))
                .where(isUserSeq(userSeq))
                .where(game.createDt.between(today.atStartOfDay(), today.plusDays(1).atStartOfDay()))
                .orderBy(game.score.max().desc(), game.createDt.max().asc())
                .limit(101)
                .fetch();
        return result;
    }

    private BooleanExpression isCntryCd(String cntryCd) {
        return StringUtils.hasText(cntryCd) ? user.cntryCd.eq(cntryCd) : null;
    }

    private BooleanExpression isUserSeq(Long userSeq) {
        return Objects.isNull(userSeq) ? null : user.userSeq.eq(userSeq);
    }
}
