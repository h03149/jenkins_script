package org.sr4s.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class SettingDto {
    private Long settingSeq;

    private Long userSeq;

    private Long keypadSeq;

    private Long themeSeq;

    private String adsYn;
}
