package org.sr4s.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.sr4s.domain.entity.GameResult;

@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class GameResultDto {

    private Long gameSeq;

    private Long userSeq;

    private int score;
}
