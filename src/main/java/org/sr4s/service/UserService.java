package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.domain.entity.Setting;
import org.sr4s.domain.entity.UserMaster;
import org.sr4s.domain.repository.SettingRepository;
import org.sr4s.domain.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final SettingRepository settingRepository;

    @Transactional
    public Response<Object> createUser(UserMasterDto user) {
        UserMaster userEntity = userRepository.findOneByUuid(user.getUuid());

        if (userEntity == null) {
            userEntity = user.dtoToEntity();
            userEntity = userRepository.save(userEntity);

            Setting settingEntity = Setting.builder()
                                            .user(userEntity)
                                            .build();
            settingRepository.save(settingEntity);
        }

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .data(userEntity.EntityToDto())
                .build();
    }

    @Transactional
    public Response<Object> getUserInfo(String uuid) {
        UserMaster userEntity = userRepository.findOneByUuid(uuid);

        UserMasterDto userDto = userEntity.EntityToDto();

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .data(userDto)
                .build();
    }
}
