package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.CodeDto;
import org.sr4s.domain.dto.KeypadDto;
import org.sr4s.domain.entity.ComCdDtl;
import org.sr4s.domain.entity.Keypad;
import org.sr4s.domain.repository.CodeRepository;
import org.sr4s.domain.repository.KeypadRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CodeService {
    private final CodeRepository codeRepository;
    @Transactional
    public Response<Object> getCodeList(String cdGrp) {
        List<ComCdDtl> codes = codeRepository.findByCdGrp(cdGrp);
        List<CodeDto> codeList = codes.stream()
                .map(code -> new CodeDto(code.getCdDtlSeq(), code.getCdGrp(), code.getCdDtlNm(), code.getCode()))
                .collect(Collectors.toList());

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .data(codeList)
                .build();
    }
}
