package org.sr4s.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseHistoryDto {
    private Long histSeq;

    private Long userSeq;

    private String goodsType;

    private Long productId;

    private String orderId;

    private String trxToken;

    private LocalDateTime purchaseDt;
}
