package org.youngmonkeys.message.box.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();
    private Boolean deleted;
}
