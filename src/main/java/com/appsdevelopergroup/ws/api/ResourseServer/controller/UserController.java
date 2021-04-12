package com.appsdevelopergroup.ws.api.ResourseServer.controller;


import com.appsdevelopergroup.ws.api.ResourseServer.pojos.UserRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/status/check")
    public String status() {
        return "Working...";
    }


    //@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    @Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("Iskander", "Sapiyev","5f3fb480-f86c-4514-8d23-ca88d66c6253");
    }


}
