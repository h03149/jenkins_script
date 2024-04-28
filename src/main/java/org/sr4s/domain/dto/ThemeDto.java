package org.sr4s.domain.dto;

import lombok.*;
import org.sr4s.domain.entity.CommonEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ThemeDto {

    private Long themeSeq;

    private String themeNm;
    
}
