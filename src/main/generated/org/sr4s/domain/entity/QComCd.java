package org.sr4s.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComCd is a Querydsl query type for ComCd
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComCd extends EntityPathBase<ComCd> {

    private static final long serialVersionUID = 1506254843L;

    public static final QComCd comCd = new QComCd("comCd");

    public final QCommonEntity _super = new QCommonEntity(this);

    public final StringPath cdGrp = createString("cdGrp");

    public final StringPath cdGrpNm = createString("cdGrpNm");

    public final NumberPath<Long> cdSeq = createNumber("cdSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public QComCd(String variable) {
        super(ComCd.class, forVariable(variable));
    }

    public QComCd(Path<? extends ComCd> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComCd(PathMetadata metadata) {
        super(ComCd.class, metadata);
    }

}

