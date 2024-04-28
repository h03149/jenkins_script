package org.sr4s.domain.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "THEME_SEQ_GENERATOR",
        sequenceName = "theme_seq",
        allocationSize = 1)
public class Theme extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "THEME_SEQ_GENERATOR")
    private Long themeSeq;

    @Column(nullable = false)
    private String themeNm;
    
}
