package org.youngmonkeys.message.box.entitiy;

import com.tvd12.ezyfox.annotation.EzyId;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EzyCollection
@EqualsAndHashCode(of = {"userId", "key"}, callSuper = false)
public class UserData extends BaseEntity {
    @EzyId
    private long userId;
    @EzyId
    private String key;
    private String value;
}
