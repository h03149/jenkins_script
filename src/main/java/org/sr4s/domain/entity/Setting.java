package org.sr4s.domain.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
@SequenceGenerator(
        name = "SETTING_SEQ_GENERATOR",
        sequenceName = "setting_seq",
        allocationSize = 1)
public class Setting extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "SETTING_SEQ_GENERATOR")
    private Long settingSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private UserMaster user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keypad_seq")
    private Keypad keypad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_seq")
    private Theme theme;

    @ColumnDefault(value = "Y")
    private String adsYn;

    public void updateSetting (Keypad keypad, Theme theme) {
        this.keypad = keypad;
        this.theme = theme;
    }
}
