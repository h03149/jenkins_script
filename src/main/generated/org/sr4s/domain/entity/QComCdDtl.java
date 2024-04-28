package org.sr4s.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComCdDtl is a Querydsl query type for ComCdDtl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComCdDtl extends EntityPathBase<ComCdDtl> {

    private static final long serialVersionUID = -980211743L;

    public static final QComCdDtl comCdDtl = new QComCdDtl("comCdDtl");

    public final QCommonEntity _super = new QCommonEntity(this);

    public final StringPath cdDtlNm = createString("cdDtlNm");

    public final NumberPath<Long> cdDtlSeq = createNumber("cdDtlSeq", Long.class);

    public final StringPath cdGrp = createString("cdGrp");

    public final StringPath code = createString("code");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public QComCdDtl(String variable) {
        super(ComCdDtl.class, forVariable(variable));
    }

    public QComCdDtl(Path<? extends ComCdDtl> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComCdDtl(PathMetadata metadata) {
        super(ComCdDtl.class, metadata);
    }

}

