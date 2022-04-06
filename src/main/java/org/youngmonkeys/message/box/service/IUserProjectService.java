package org.youngmonkeys.message.box.service;

import org.youngmonkeys.message.box.entitiy.UserProject;

import java.util.List;

public interface IUserProjectService {

    String saveUserProject(UserProject userProject, long userId);

    boolean exitsProjectName(String projectName);

    List<UserProject> findByUserId(long userId,int page,int size);

    UserProject getByKey(String key);

}
