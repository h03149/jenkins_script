package org.sr4s.domain.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class ComCd extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdSeq;

    @Column(nullable = false)
    private String cdGrp;

    @Column(nullable = false)
    private String cdGrpNm;

}
