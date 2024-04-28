package org.sr4s.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * org.sr4s.domain.dto.QScoreDto is a Querydsl Projection type for ScoreDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScoreDto extends ConstructorExpression<ScoreDto> {

    private static final long serialVersionUID = 1609150816L;

    public QScoreDto(com.querydsl.core.types.Expression<String> cntryCd, com.querydsl.core.types.Expression<Integer> score) {
        super(ScoreDto.class, new Class<?>[]{String.class, int.class}, cntryCd, score);
    }

    public QScoreDto(com.querydsl.core.types.Expression<String> cntryCd, com.querydsl.core.types.Expression<Integer> score, com.querydsl.core.types.Expression<String> userNm, com.querydsl.core.types.Expression<Long> userSeq) {
        super(ScoreDto.class, new Class<?>[]{String.class, int.class, String.class, long.class}, cntryCd, score, userNm, userSeq);
    }

    public QScoreDto(com.querydsl.core.types.Expression<Integer> score, com.querydsl.core.types.Expression<String> userNm, com.querydsl.core.types.Expression<Long> userSeq) {
        super(ScoreDto.class, new Class<?>[]{int.class, String.class, long.class}, score, userNm, userSeq);
    }

}

