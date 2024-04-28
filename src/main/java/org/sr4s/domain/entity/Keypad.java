package org.sr4s.domain.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "KEYPAD_SEQ_GENERATOR",
        sequenceName = "keypad_seq",
        allocationSize = 1)
public class Keypad extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    , generator = "KEYPAD_SEQ_GENERATOR")
    private Long keypadSeq;

    @Column(nullable = false)
    private String keypadNm;
    
}
