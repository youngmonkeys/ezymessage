package com.ezy.databasesetting.repository;

import com.ezy.databasesetting.entitiy.ServiceUserTokens;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface ServiceUserTokenRepository extends EzyMongoRepository<Long, ServiceUserTokens> {
}
