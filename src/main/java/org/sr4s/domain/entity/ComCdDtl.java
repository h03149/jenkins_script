package org.sr4s.domain.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class ComCdDtl extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdDtlSeq;

    private String cdGrp;

    @Column(nullable = false)
    private String cdDtlNm;

    @Column(nullable = false)
    private String code;
    
}
