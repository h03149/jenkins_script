package org.sr4s.domain.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CodeDto {

    private Long cdSeq;

    private String cdGrp;

    private String cdNm;

    private String code;
    
}
