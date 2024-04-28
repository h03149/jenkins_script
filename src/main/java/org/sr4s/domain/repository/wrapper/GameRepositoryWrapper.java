package org.sr4s.domain.repository.wrapper;

import org.sr4s.domain.dto.ScoreDto;

import java.util.List;

public interface GameRepositoryWrapper {
    List<ScoreDto> findCntryScoreList();
    ScoreDto findCntryScore(String cntryCd);
    List<ScoreDto> findScoreList();
    List<ScoreDto> findUserScore(String cntryCd, Long userSeq);
}
