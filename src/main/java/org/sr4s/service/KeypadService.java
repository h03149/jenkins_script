package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.KeypadDto;
import org.sr4s.domain.dto.ThemeDto;
import org.sr4s.domain.entity.Keypad;
import org.sr4s.domain.entity.Theme;
import org.sr4s.domain.repository.KeypadRepository;
import org.sr4s.domain.repository.ThemeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeypadService {
    private final KeypadRepository keypadRepository;
    @Transactional
    public Response<Object> getKeypadList() {
        List<Keypad> keypads = keypadRepository.findAll();
        List<KeypadDto> keypadList = keypads.stream()
                .map(keypad -> new KeypadDto(keypad.getKeypadSeq(), keypad.getKeypadNm()))
                .collect(Collectors.toList());

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .data(keypadList)
                .build();
    }
}
