package org.sr4s.domain.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class KeypadDto {

    private Long keypadSeq;

    private String keypadNm;
    
}
