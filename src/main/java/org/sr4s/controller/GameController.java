package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.GameResultDto;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.service.GameService;

@RestController
@RequestMapping(value = "/api/v1/game")
@RequiredArgsConstructor
@Slf4j
public class GameController {

    private final GameService gameService;

    @PostMapping("/score/create")
    public Response<Object> createScore(@RequestBody GameResultDto score) {
        return gameService.createScore(score);
    }


    /**
     * 8위까지 국가 랭킹 리스트
     */
    @GetMapping("/score/cntry")
    public Response<Object> getCntryScoreList() {
        return gameService.getCntryScoreList();
    }

    /**
     * 내 국가 랭킹
     */
    @GetMapping("/score/{cntryCd}")
    public Response<Object> getCntryScore(@PathVariable(value = "cntryCd") String cntryCd) {
        return gameService.getCntryScore(cntryCd);
    }

    /**
     * 전체 개인 랭킹 리스트
     */
    @GetMapping("/score/list")
    public Response<Object> getScoreList() {
        return gameService.getScoreList();
    }

    /**
     * 국가 내 개인 랭킹
     */
    @GetMapping("/score/user")
    public Response<Object> getUserScore(@RequestParam(value = "cntryCd") String cntryCd
                                                , @RequestParam(value = "userSeq", required = false) Long userSeq) {
        return gameService.getUserScore(cntryCd, userSeq);
    }

}
