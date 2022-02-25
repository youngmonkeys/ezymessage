package org.youngmonkeys.message.box.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataId implements Serializable {
    private long userId;
    private String key;
}
