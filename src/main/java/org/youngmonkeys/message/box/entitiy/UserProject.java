package org.youngmonkeys.message.box.entitiy;

import com.tvd12.ezyfox.annotation.EzyId;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EzyCollection
@EqualsAndHashCode(of = {"id"}, callSuper = false)
public class UserProject extends BaseEntity {

    @EzyId
    private String id;
    private String projectName;
    private String key;
    private long createdBy;
    private long projectNumber;

    public UserProject(String projectName) {
        this.projectName = projectName;
    }
}
