package com.ezy.databasesetting.entitiy;

import com.tvd12.ezyfox.annotation.EzyId;
import com.tvd12.ezyfox.database.annotation.EzyCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EzyCollection
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @EzyId
    private long id;
    private String name;
    private String serviceToken;
    private String ownerUserId;
}
