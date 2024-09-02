package com.userservice.userservice.services;

import com.userservice.userservice.dtos.UserDto;
import com.userservice.userservice.models.Session;
import com.userservice.userservice.models.User;
import com.userservice.userservice.repositories.SessionRepository;
import com.userservice.userservice.repositories.UserRepository;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.http.RequestEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, SessionRepository sessionRepository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public UserDto signIn(String mailId, String password){
        Optional<User> userOptional = userRepository.findByMailId(mailId);
        if (userOptional.isEmpty()){
            return null;
        }
        User user = userOptional.get();
        if(!user.getPassword().equals(password)){
            return null;
        }
        UserDto userDto = UserDto.from(user);
        return userDto;
    }

    public UserDto signUp(
            String mailId,
            Long phoneNumber,
            String password,
            String securityQuestion,
            String securityAnswer){

        User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setPhoneNumber(phoneNumber);
        user.setMailId(mailId);
        user.setSecurityQuestion(securityQuestion);
        user.setSecurityAnswer(securityAnswer);

//        Session session = new Session();
//        session.setUser(user);
//        session.setSessionStatus(Boolean.TRUE);
//        sessionRepository.save(session);

        return UserDto.from(userRepository.save(user));
    }
}
