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
public class ServiceUserTokens {
    @EzyId
    private long id;
    private long serviceId;
    private String username;
    private String userToken;
}
