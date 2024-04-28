package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.PurchaseDto;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.domain.entity.Purchase;
import org.sr4s.domain.entity.Setting;
import org.sr4s.domain.entity.UserMaster;
import org.sr4s.domain.repository.PurchaseRepository;
import org.sr4s.domain.repository.SettingRepository;
import org.sr4s.domain.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseService {

    private final UserRepository userRepository;

    private final PurchaseRepository purchaseRepository;

    @Transactional
    public Response<Object> purchase(PurchaseDto dto) {
        UserMaster user = userRepository.findOneByUserSeq(dto.getUserSeq());
        Purchase entity = Purchase.builder()
                                    .user(user)
                                    .goodsType(dto.getGoodsType())
                                    .productId(dto.getProductId())
                                    .build();
        purchaseRepository.save(entity);

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .data(entity)
                .build();
    }

    @Transactional
    public Response<Object> getPurchaseList(Long userSeq, String goodsType) {
        UserMaster user = userRepository.findOneByUserSeq(userSeq);
        List<Purchase> entities  = purchaseRepository.findByUserAndGoodsType(user, goodsType);

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .data(entities)
                .build();
    }
}
