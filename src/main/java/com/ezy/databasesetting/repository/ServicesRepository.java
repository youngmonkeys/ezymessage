package com.ezy.databasesetting.repository;

import com.ezy.databasesetting.entitiy.Services;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface ServicesRepository extends EzyMongoRepository<Long, Services> {
}
