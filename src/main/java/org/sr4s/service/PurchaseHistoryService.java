package org.sr4s.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.PurchaseDto;
import org.sr4s.domain.dto.PurchaseHistoryDto;
import org.sr4s.domain.entity.Purchase;
import org.sr4s.domain.entity.PurchaseHistory;
import org.sr4s.domain.entity.UserMaster;
import org.sr4s.domain.repository.PurchaseHistoryRepository;
import org.sr4s.domain.repository.PurchaseRepository;
import org.sr4s.domain.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseHistoryService {

    private final UserRepository userRepository;

    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Transactional
    public Response<Object> purchase(PurchaseHistoryDto dto) {
        UserMaster user = userRepository.findOneByUserSeq(dto.getUserSeq());
        PurchaseHistory entity = PurchaseHistory.builder()
                                    .user(user)
                                    .orderId(dto.getOrderId())
                                    .trxToken(dto.getTrxToken())
                                    .goodsType(dto.getGoodsType())
                                    .productId(dto.getProductId())
                                    .purchaseDt(dto.getPurchaseDt())
                                    .build();
        purchaseHistoryRepository.save(entity);

        return new Response<>().builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("SUCCESS")
                .build();
    }
}
