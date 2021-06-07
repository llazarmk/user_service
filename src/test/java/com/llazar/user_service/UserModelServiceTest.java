package com.llazar.user_service;

import com.llazar.user_service.model.UserModel;
import com.llazar.user_service.security.JwtTokenProvider;
import com.llazar.user_service.service.UserRequest;

import com.llazar.user_service.service.UserService;
import com.llazar.user_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.text.ParseException;

public class UserModelServiceTest {

    private UserRequest userRequest;

    private UserRepository userRepository;

    private UserService userService;

    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    void init()
    {
        // "yyyy-MM-dd"
        // Create a test user request
        userRequest = new UserRequest(
                "user1",
                "user@mail.com",
                "1234",
                "firstname",
                "lastname",
                "address",
                "2021:05:31"
        );
        // pass the user repository as dependency injection

        userService = new UserService(userRepository, jwtTokenProvider);
    }

    @Test
    void test_createUser() throws ParseException {
        System.out.println("Print User Request ");
        UserModel userModel = userService.createUser(userRequest);
        Assert.assertEquals(userModel.getUsername(),"user1");
        Assert.assertEquals(userModel.getEmail(),"user@mail.com");
        Assert.assertNotEquals(userModel.getPassword(),"1234");

    }
}