package com.userservice.userservice.dtos;

import com.userservice.userservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String mailId;
    private Long phoneNumber;


    public static  UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setMailId(user.getMailId());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }
}
