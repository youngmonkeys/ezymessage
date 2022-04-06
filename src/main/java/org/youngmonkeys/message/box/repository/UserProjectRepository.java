package org.youngmonkeys.message.box.repository;

import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyQuery;
import com.tvd12.ezyfox.database.annotation.EzyRepository;
import com.tvd12.ezyfox.util.Next;
import org.youngmonkeys.message.box.entitiy.UserProject;

import java.util.List;

@EzyRepository
public interface UserProjectRepository extends EzyMongoRepository<Long, UserProject> {


    @EzyQuery("{$query:{createdBy:{$eq:?0}}, $orderby:{createTime:-1}}")
    List<UserProject> findByCreatedByEq(long userId, Next next);

    @EzyQuery("{$query:{key:{$eq:?0}}}")
    UserProject findByKeyEq(String key);
}
