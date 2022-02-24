package org.youngmonkeys.message.box.controller;

import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import org.youngmonkeys.message.box.annotation.UserId;
import org.youngmonkeys.message.box.entitiy.User;
import org.youngmonkeys.message.box.entitiy.UserStatus;
import org.youngmonkeys.message.box.service.impl.UserServiceImpl;

@Controller
public class HomeController {

    @EzyAutoBind
    private UserServiceImpl loginService;

    @DoGet("/")
    public ResponseEntity index() {
        return ResponseEntity.ok();
    }

    @DoGet("/home")
    public ResponseEntity home(@UserId long userId) {
        User user = loginService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.badRequest();
        }
        return ResponseEntity.ok(user.getEmail());
    }
}
