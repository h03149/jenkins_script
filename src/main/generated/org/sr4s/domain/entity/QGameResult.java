package org.sr4s.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameResult is a Querydsl query type for GameResult
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameResult extends EntityPathBase<GameResult> {

    private static final long serialVersionUID = 1283312662L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameResult gameResult = new QGameResult("gameResult");

    public final QCommonEntity _super = new QCommonEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final NumberPath<Long> gameSeq = createNumber("gameSeq", Long.class);

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public final QUserMaster user;

    public QGameResult(String variable) {
        this(GameResult.class, forVariable(variable), INITS);
    }

    public QGameResult(Path<? extends GameResult> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameResult(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameResult(PathMetadata metadata, PathInits inits) {
        this(GameResult.class, metadata, inits);
    }

    public QGameResult(Class<? extends GameResult> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUserMaster(forProperty("user")) : null;
    }

}

