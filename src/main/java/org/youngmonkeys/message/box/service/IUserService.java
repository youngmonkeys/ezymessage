package org.youngmonkeys.message.box.service;

import org.youngmonkeys.message.box.entitiy.User;

public interface IUserService {
    User getUserInfoByEmail(String email);

    User getUserById(long userId);

    void saveUser(User user);
}
