package org.youngmonkeys.message.box.entitiy;

import com.tvd12.ezyfox.annotation.EzyId;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EzyCollection
public class User extends BaseEntity {
    @EzyId
    private long id;
    private String email;
    private String fullName;
    private String firstName;
    private String lastName;
    private String avatarURL;
    private Date birthOfDate;
    private int gender;
    private String password;
    private UserStatus status;
}
