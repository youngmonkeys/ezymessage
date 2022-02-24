package org.youngmonkeys.message.box.controller;

import com.tvd12.ezydata.database.repository.EzyMaxIdRepository;
import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.sercurity.EzySHA256;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoPost;
import com.tvd12.ezyhttp.server.core.annotation.RequestBody;
import org.youngmonkeys.message.box.entitiy.User;
import org.youngmonkeys.message.box.entitiy.UserStatus;
import org.youngmonkeys.message.box.request.UpdateUserRequest;
import org.youngmonkeys.message.box.service.IUserService;

import java.util.Objects;

@Controller
public class RegisterController {

    @EzyAutoBind
    private IUserService userService;

    @EzyAutoBind
    private EzyMaxIdRepository ezyMaxIdRepository;

    @DoPost("/register")
    public ResponseEntity registerUser(
            @RequestBody UpdateUserRequest request
    ) {
        User user = userService.getUserInfoByEmail(request.getEmail());
        if (Objects.nonNull(user)) {
            return ResponseEntity.badRequest("user with id: " + user.getEmail() + " already");
        }
        user = new User();
        user.setId(ezyMaxIdRepository.incrementAndGet("user"));
        user.setEmail(request.getEmail());
        user.setFullName(request.getFirstName() + " " + request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setStatus(UserStatus.REGISTER);
        user.setPassword(EzySHA256.cryptUtfToLowercase(request.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("Register Success");
    }
}
