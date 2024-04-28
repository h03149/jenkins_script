package org.sr4s.domain.entity;

import lombok.*;
import org.sr4s.domain.dto.UserMasterDto;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "user_seq",
        allocationSize = 1)
public class UserMaster extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="USER_SEQ_GENERATOR")
    private Long userSeq;

    @Column(nullable = false)
    private String userNm;

    @Column(nullable = false)
    private String cntryCd;

    @Column(nullable = false)
    private String uuid;

    public UserMasterDto EntityToDto() {
        return UserMasterDto.builder()
                .userNm(this.userNm)
                .cntryCd(this.cntryCd)
                .uuid(this.uuid)
                .userSeq(this.userSeq)
                .build();
    }
    
}
