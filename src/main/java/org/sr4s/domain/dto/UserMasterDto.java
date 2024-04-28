package org.sr4s.domain.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.sr4s.domain.entity.UserMaster;

@Data
@Builder
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class UserMasterDto {

    private Long userSeq;

    private String userNm;

    private String cntryCd;

    private String uuid;

    public UserMaster dtoToEntity() {
        return UserMaster.builder()
                .userNm(this.userNm)
                .cntryCd(this.cntryCd)
                .uuid(this.uuid)
                .userSeq(this.userSeq)
                .build();
    }
    
}
