package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.SettingDto;
import org.sr4s.service.SettingService;

@RestController
@RequestMapping(value = "/api/v1/setting")
@RequiredArgsConstructor
@Slf4j
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/get/{userSeq}")
    public Response<Object> getSetting(@PathVariable(value = "userSeq") Long userSeq) {
        return settingService.getSetting(userSeq);
    }

    @PutMapping("/keypad")
    public Response<Object> applyKeypad(@RequestParam("userSeq") Long userSeq, @RequestParam("keypadSeq") Long keypadSeq) {
        return settingService.applyKeypad(userSeq, keypadSeq);
    }

    @PutMapping("/theme")
    public Response<Object> applyTheme(@RequestParam("userSeq") Long userSeq, @RequestParam("themeSeq") Long themeSeq) {
        return settingService.applyTheme(userSeq, themeSeq);
    }

    @PutMapping("/ads")
    public Response<Object> removeAds(@RequestParam("userSeq") Long userSeq) {
        return settingService.removeAds(userSeq);
    }

    @PutMapping("/update")
    public Response<Object> setSetting(@RequestBody SettingDto request) {
        return settingService.setSetting(request);
    }
}
