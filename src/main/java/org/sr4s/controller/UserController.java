package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<Object> createUser(@RequestBody UserMasterDto user) {
        return userService.createUser(user);
    }

    @GetMapping("/get/{uuid}")
    public Response<Object> getUserInfo(@PathVariable(value = "uuid") String uuid) {
        return userService.getUserInfo(uuid);
    }
}
