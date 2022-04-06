package org.youngmonkeys.message.box.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProjectRequest {
    private String projectName;
    private String databaseRegisterId;
    private String accessToken;
}
