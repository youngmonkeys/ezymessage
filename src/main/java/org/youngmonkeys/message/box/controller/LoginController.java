package org.youngmonkeys.message.box.controller;

import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.sercurity.EzySHA256;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoPost;
import com.tvd12.ezyhttp.server.core.annotation.RequestBody;
import com.tvd12.ezyhttp.server.core.annotation.RequestCookie;
import org.youngmonkeys.message.box.entitiy.User;
import org.youngmonkeys.message.box.request.LoginRequest;
import org.youngmonkeys.message.box.service.IAuthenticationService;
import org.youngmonkeys.message.box.service.IUserService;

@Controller
public class LoginController {

    @EzyAutoBind
    private IUserService userService;

    @EzyAutoBind
    private IAuthenticationService authenticationService;

    @DoPost("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        User user = userService.getUserInfoByEmail(loginRequest.getEmail());
        if (user != null) {
            String hashPassword = EzySHA256.cryptUtfToLowercase(loginRequest.getPassword());
            if (hashPassword.equals(user.getPassword())) {
                String accessToken = authenticationService.generateAccessToken(user.getId());
                return ResponseEntity.ok(accessToken);
            }
        }
        return ResponseEntity.badRequest("User Info not correct");
    }

    @DoPost("/logout")
    public ResponseEntity logout(@RequestCookie("accessToken") String accessToken) {
        authenticationService.removeAccessToken(accessToken);
        return ResponseEntity.ok("logout success");
    }

}
