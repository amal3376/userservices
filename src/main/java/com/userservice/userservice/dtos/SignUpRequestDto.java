package com.userservice.userservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String mailId;
    private Long phoneNumber;
    private String password;
    private String securityQuestion;
    private String securityAnswer;

}
