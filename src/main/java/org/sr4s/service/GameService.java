package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.GameResultDto;
import org.sr4s.domain.dto.ScoreDto;
import org.sr4s.domain.entity.GameResult;
import org.sr4s.domain.repository.GameRepository;
import org.sr4s.domain.repository.ScoreRepository;
import org.sr4s.domain.repository.UserRepository;
import org.sr4s.domain.repository.wrapper.GameRepositoryWrapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {

    private final GameRepository gameRepository;

    private final ScoreRepository scoreRepository;

    private final UserRepository userRepository;

    private final GameRepositoryWrapper gameRepositoryWrapper;

    @Transactional
    public Response<Object> createScore(GameResultDto score) {
        GameResult scoreEntity = GameResult.builder()
                                    .user(userRepository.findOneByUserSeq(score.getUserSeq()))
                                    .score(score.getScore())
                                    .build();
        gameRepository.save(scoreEntity);

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("INSERT SCORE SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getCntryScoreList() {
        List<ScoreDto> cntryScoreList = scoreRepository.findCntryScoreList();
        cntryScoreList.stream().limit(8).collect(Collectors.toList());
        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(cntryScoreList)
                .message("SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getCntryScore(String cntryCd) {
        List<ScoreDto> scoreList = scoreRepository.findCntryScoreList();
        //ScoreDto score = scoreList.stream().filter(data -> cntryCd.equals(data.getCntryCd())).findFirst().orElse(null);
        ScoreDto score = IntStream.range(0, scoreList.size())
                .filter(i -> scoreList.get(i).getCntryCd().equals(cntryCd))
                .mapToObj(i -> {
                    ScoreDto dto = scoreList.get(i);
                    dto.setRanking(i + 1);
                    return dto;
                })
                .findFirst()
                .orElse(null);

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(score)
                .message("SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getScoreList() {
        List<ScoreDto> score = gameRepositoryWrapper.findScoreList();
        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(score)
                .message("SUCCESS")
                .build();
    }
    @Transactional
    public Response<Object> getUserScore(String cntryCd, Long userSeq) {
        List<ScoreDto> score = gameRepositoryWrapper.findUserScore(cntryCd, userSeq);
        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .data(score)
                .message("SUCCESS")
                .build();
    }
}
