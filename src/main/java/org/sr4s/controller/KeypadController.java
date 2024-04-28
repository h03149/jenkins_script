package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sr4s.domain.common.Response;
import org.sr4s.service.KeypadService;

@RestController
@RequestMapping(value = "/api/v1/keypad")
@RequiredArgsConstructor
@Slf4j
public class KeypadController {

    private final KeypadService keypadService;
    @GetMapping("/list")
    public Response<Object> getKeypadList() { return keypadService.getKeypadList(); }
}
