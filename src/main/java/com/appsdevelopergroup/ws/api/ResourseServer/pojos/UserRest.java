package com.appsdevelopergroup.ws.api.ResourseServer.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {
    private String userFirstName;
    private String userLastName;
    private String userId;
}
