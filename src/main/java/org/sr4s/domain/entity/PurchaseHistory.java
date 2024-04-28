package org.sr4s.domain.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
@Table(name = "purchase_hist")
@SequenceGenerator(
        name = "HIST_SEQ_GENERATOR",
        sequenceName = "hist_seq",
        allocationSize = 1)
public class PurchaseHistory extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "HIST_SEQ_GENERATOR")
    private Long histSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private UserMaster user;

    @Column(nullable = false)
    private Long productId;

    private String trxToken;

    private String goodsType;

    private String orderId;

    @CreationTimestamp
    private LocalDateTime purchaseDt;

}
