package org.youngmonkeys.message.box.service.impl;

import com.tvd12.ezydata.database.repository.EzyMaxIdRepository;
import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.sercurity.EzySHA256;
import com.tvd12.ezyfox.util.Next;
import com.tvd12.ezyhttp.server.core.annotation.Service;
import org.youngmonkeys.message.box.entitiy.UserProject;
import org.youngmonkeys.message.box.repository.UserProjectRepository;
import org.youngmonkeys.message.box.request.UserProjectRequest;
import org.youngmonkeys.message.box.service.IUserProjectService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserUserProjectService implements IUserProjectService {
    @EzyAutoBind
    private UserProjectRepository userProjectRepository;
    @EzyAutoBind
    private EzyMaxIdRepository ezyMaxIdRepository;

    @Override
    public String saveUserProject(UserProject userProject, long userId) {
        try {
            String key =  EzySHA256.cryptUtfToLowercase(
                    userProject.getProjectName() + UUID.randomUUID().toString() + System.currentTimeMillis()
            );
            userProject.setKey(key);
            userProject.setCreatedBy(userId);
            userProject.setCreateTime(LocalDateTime.now());
            userProject.setProjectNumber(ezyMaxIdRepository.incrementAndGet("user_project"));
            userProjectRepository.save(userProject);

            return key;
        }catch (Exception e){
            return "";
        }

    }

    public List<UserProject> findByUserId(long userId,int page,int size){
        List<UserProject> userProjectList = new ArrayList<>();
        userProjectList = userProjectRepository.findByCreatedByEq(userId, Next.fromSkipLimit((page+1)*size, size));
        return userProjectList;
    }

    public UserProject buildInfoFromRequest(UserProjectRequest userProjectRequest) {
        return new UserProject(userProjectRequest.getProjectName());
    }

    public UserProject getByKey(String key){
        return userProjectRepository.findByKeyEq(key);
    }

    @Override
    public boolean exitsProjectName(String projectName) {
        return !userProjectRepository.findListByField("projectName", projectName).isEmpty();
    }
}
