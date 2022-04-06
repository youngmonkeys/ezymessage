package org.youngmonkeys.message.box.entitiy;

import com.tvd12.ezyfox.annotation.EzyId;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EzyCollection
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken extends BaseEntity {
    @EzyId
    private String accessToken;
    private long userId;
    private LocalDateTime expireAt;
    private LocalDateTime expireIn;
    private LocalDateTime firstIssueAt;
}
