package org.sr4s.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSetting is a Querydsl query type for Setting
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSetting extends EntityPathBase<Setting> {

    private static final long serialVersionUID = 1143723593L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSetting setting = new QSetting("setting");

    public final QCommonEntity _super = new QCommonEntity(this);

    public final StringPath adsYn = createString("adsYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDt = _super.createDt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final QKeypad keypad;

    public final NumberPath<Long> settingSeq = createNumber("settingSeq", Long.class);

    public final QTheme theme;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDt = _super.updateDt;

    public final QUserMaster user;

    public QSetting(String variable) {
        this(Setting.class, forVariable(variable), INITS);
    }

    public QSetting(Path<? extends Setting> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSetting(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSetting(PathMetadata metadata, PathInits inits) {
        this(Setting.class, metadata, inits);
    }

    public QSetting(Class<? extends Setting> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.keypad = inits.isInitialized("keypad") ? new QKeypad(forProperty("keypad")) : null;
        this.theme = inits.isInitialized("theme") ? new QTheme(forProperty("theme")) : null;
        this.user = inits.isInitialized("user") ? new QUserMaster(forProperty("user")) : null;
    }

}

