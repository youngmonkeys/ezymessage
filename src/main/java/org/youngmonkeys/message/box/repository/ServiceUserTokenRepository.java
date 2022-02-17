package org.youngmonkeys.message.box.repository;

import org.youngmonkeys.message.box.entitiy.ServiceUserTokens;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface ServiceUserTokenRepository extends EzyMongoRepository<Long, ServiceUserTokens> {
}
