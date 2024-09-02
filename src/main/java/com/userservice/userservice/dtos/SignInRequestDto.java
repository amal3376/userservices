package com.userservice.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequestDto {
    private String mailId;
    private Long phoneNumber;
    private String password;
}
