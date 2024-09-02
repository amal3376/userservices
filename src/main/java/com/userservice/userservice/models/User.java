package com.userservice.userservice.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String mailId;
    private Long phoneNumber;
    private String password;
    private String securityQuestion;
    private String securityAnswer;

}
