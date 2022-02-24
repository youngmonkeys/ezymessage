package org.youngmonkeys.message.box.repository;

import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;
import org.youngmonkeys.message.box.entitiy.AccessToken;

@EzyRepository
public interface AccessTokenRepository extends EzyMongoRepository<String, AccessToken> {
}
