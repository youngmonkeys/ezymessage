package org.youngmonkeys.message.box.repository;

import org.youngmonkeys.message.box.entitiy.Services;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface ServicesRepository extends EzyMongoRepository<Long, Services> {
}
