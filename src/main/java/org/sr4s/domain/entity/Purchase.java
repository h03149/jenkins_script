package org.sr4s.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "PURCHASE_SEQ_GENERATOR",
        sequenceName = "purchase_seq",
        allocationSize = 1)
public class Purchase extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "PURCHASE_SEQ_GENERATOR")
    private Long uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private UserMaster user;

    @Column(nullable = false)
    private String goodsType;

    @Column(nullable = false)
    private Long productId;

}
