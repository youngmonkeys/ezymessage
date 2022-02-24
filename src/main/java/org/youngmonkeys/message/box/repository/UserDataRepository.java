package org.youngmonkeys.message.box.repository;

import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;
import org.youngmonkeys.message.box.entitiy.UserData;

@EzyRepository
public interface UserDataRepository extends EzyMongoRepository<Long, UserData> {
}
