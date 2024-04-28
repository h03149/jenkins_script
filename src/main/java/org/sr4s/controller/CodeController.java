package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sr4s.domain.common.Response;
import org.sr4s.service.CodeService;
import org.sr4s.service.KeypadService;

@RestController
@RequestMapping(value = "/api/v1/code")
@RequiredArgsConstructor
@Slf4j
public class CodeController {

    private final CodeService codeService;
    @GetMapping("/list/{cdGrp}")
    public Response<Object> getCodeList(@PathVariable(value = "cdGrp") String cdGrp) { return codeService.getCodeList(cdGrp); }
}
