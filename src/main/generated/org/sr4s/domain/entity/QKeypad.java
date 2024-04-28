package org.sr4s.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QKeypad is a Querydsl query type for Keypad
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKeypad extends EntityPathBase<Keypad> {

    private static final long serialVersionUID = -330541381L;

    public static final QKeypad keypad = new QKeypad("keypad");

    public final QCommonEntity _super = new QCommonEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath keypadNm = createString("keypadNm");

    public final NumberPath<Long> keypadSeq = createNumber("keypadSeq", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public QKeypad(String variable) {
        super(Keypad.class, forVariable(variable));
    }

    public QKeypad(Path<? extends Keypad> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKeypad(PathMetadata metadata) {
        super(Keypad.class, metadata);
    }

}

