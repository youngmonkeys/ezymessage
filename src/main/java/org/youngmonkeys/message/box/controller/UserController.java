package org.youngmonkeys.message.box.controller;

import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.sercurity.EzySHA256;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import com.tvd12.ezyhttp.server.core.annotation.DoPost;
import com.tvd12.ezyhttp.server.core.annotation.RequestBody;
import org.youngmonkeys.message.box.annotation.UserId;
import org.youngmonkeys.message.box.entitiy.User;
import org.youngmonkeys.message.box.entitiy.UserStatus;
import org.youngmonkeys.message.box.request.UpdateUserRequest;
import org.youngmonkeys.message.box.service.IUserService;

@Controller
public class UserController {

    @EzyAutoBind
    private IUserService userService;

    @DoGet("/user/update")
    public ResponseEntity userUpdateGet(@UserId long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @DoPost("/user/save")
    public ResponseEntity userSavePost(
            @UserId long userId,
            @RequestBody UpdateUserRequest request
    ) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound("user with id: " + userId + " not found");
        }
        user.setEmail(request.getEmail());
        user.setFullName(request.getFirstName() + " " + request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setStatus(UserStatus.UPDATED);
        user.setPassword(EzySHA256.cryptUtfToLowercase(request.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("Update user with id: " + userId + " Success");
    }
}
