package org.sr4s.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {
    private Long uuid;

    private Long userSeq;

    private String goodsType;

    private Long productId;
}
