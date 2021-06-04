package com.llazar.user_service.service;


import com.llazar.user_service.model.User;
import com.llazar.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    /* User service depends on bcrypt_encoder service */
    private static final BCryptPasswordEncoder BCRYPT_ENCODER = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    public User createUser(UserRequest request) throws ParseException {

        String username = request.username;
        String email = request.email;
        byte[] password = BCRYPT_ENCODER.encode(request.password).getBytes();
        String firstname = request.firstname;
        String lastname = request.lastname;
        String address = request.address;
        Date birthday = Parser.parseDate(request.birthday);

        return new User(username, email,password,firstname, lastname, address,birthday);
    }

    public void save(User user)
    {
        userRepository.save(user);
    }

}
