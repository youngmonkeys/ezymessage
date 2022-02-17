package com.ezy.databasesetting.entitiy;

import com.tvd12.ezyfox.annotation.EzyId;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import lombok.*;

@Getter
@Setter
@EzyCollection
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseList {
    @EzyId
    private long id;
    private String name;
}
