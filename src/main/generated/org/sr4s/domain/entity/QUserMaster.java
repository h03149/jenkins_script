package org.sr4s.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserMaster is a Querydsl query type for UserMaster
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMaster extends EntityPathBase<UserMaster> {

    private static final long serialVersionUID = 2100873076L;

    public static final QUserMaster userMaster = new QUserMaster("userMaster");

    public final QCommonEntity _super = new QCommonEntity(this);

    public final StringPath cntryCd = createString("cntryCd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public final StringPath userNm = createString("userNm");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final StringPath uuid = createString("uuid");

    public QUserMaster(String variable) {
        super(UserMaster.class, forVariable(variable));
    }

    public QUserMaster(Path<? extends UserMaster> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserMaster(PathMetadata metadata) {
        super(UserMaster.class, metadata);
    }

}

