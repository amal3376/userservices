package com.userservice.userservice.services;

import com.userservice.userservice.dtos.UserDto;
import com.userservice.userservice.models.User;
import com.userservice.userservice.repositories.UserRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto getUserDetails(Long Id){

        Optional<User> userOptional = userRepository.findById(Id);
        if(userOptional.isEmpty()){
            return null;
        }

        UserDto userDto = UserDto.from(userOptional.get());
        return userDto;
    }
}
