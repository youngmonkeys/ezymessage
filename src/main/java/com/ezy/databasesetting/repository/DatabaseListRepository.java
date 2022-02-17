package com.ezy.databasesetting.repository;

import com.ezy.databasesetting.entitiy.DatabaseList;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface DatabaseListRepository extends EzyMongoRepository<Long,DatabaseList> {
}
