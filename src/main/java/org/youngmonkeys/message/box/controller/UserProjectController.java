package org.youngmonkeys.message.box.controller;

import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.*;

import org.youngmonkeys.message.box.annotation.UserId;
import org.youngmonkeys.message.box.entitiy.UserProject;
import org.youngmonkeys.message.box.request.UserProjectRequest;
import org.youngmonkeys.message.box.service.impl.UserUserProjectService;

@Controller
public class UserProjectController {
    @EzyAutoBind
    private UserUserProjectService userProjectService;

    @DoPost("/register-message-box")
    public ResponseEntity createProject(@RequestBody UserProjectRequest userProjectRequest, @UserId long userId) {
        UserProject userProject = userProjectService
                .buildInfoFromRequest(userProjectRequest);
        if (userProjectService.exitsProjectName(userProjectRequest.getProjectName())) {
            return ResponseEntity.status(303).build();
        }
        userProjectService.saveUserProject(userProject, userId);
        return ResponseEntity
                .ok("Create Project Success");

    }

    @DoGet("/check-project-name/{projectName}")
    public ResponseEntity checkProjectName(@PathVariable String projectName) {
        return ResponseEntity.ok(userProjectService.exitsProjectName(projectName));
    }

    @DoGet("/projects")
    public ResponseEntity projectsByUserId(@UserId long userId,@RequestParam("page") int page,@RequestParam("size") int size) {
        return ResponseEntity.ok(userProjectService.findByUserId(userId,page,size));
    }

    @DoGet("/project/{key}")
    public ResponseEntity getByKey(@UserId long userId,@PathVariable String key) {
        return ResponseEntity.ok(userProjectService.getByKey(key) );
    }

}
