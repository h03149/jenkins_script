package org.sr4s.domain.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "GAME_SEQ_GENERATOR",
        sequenceName = "game_seq",
        allocationSize = 1)
public class GameResult extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="GAME_SEQ_GENERATOR")
    private Long gameSeq;

    @Column(nullable = false)
    private int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_seq")
    private UserMaster user;
    
}
