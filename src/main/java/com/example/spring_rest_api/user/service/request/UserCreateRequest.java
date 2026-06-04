package com.example.spring_rest_api.user.service.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserCreateRequest {
    private String email;
    private String password;
    private String nickname;
    private String profileImage;
}
