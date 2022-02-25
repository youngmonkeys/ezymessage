package org.youngmonkeys.message.box.service.impl;

import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import org.youngmonkeys.message.box.entitiy.User;
import org.youngmonkeys.message.box.repository.UserRepository;
import org.youngmonkeys.message.box.service.IUserService;

import java.time.LocalDateTime;

@EzySingleton
public class UserServiceImpl implements IUserService {
    @EzyAutoBind
    private UserRepository userRepository;

    @Override
    public User getUserInfoByEmail(String email) {
        return userRepository.findByField("email", email);
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void saveUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userRepository.save(user);
    }
}
