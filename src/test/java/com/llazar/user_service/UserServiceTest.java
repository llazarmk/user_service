package com.llazar.user_service;

import com.llazar.user_service.service.UserRequest;

import com.llazar.user_service.service.UserService;
import com.llazar.user_service.model.User;
import com.llazar.user_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.text.ParseException;
import java.util.Arrays;

public class UserServiceTest {

    private UserRequest userRequest;

    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void init()
    {
        // "yyyy-MM-dd"
        // Create a test user request
        userRequest = new UserRequest("user1",
                "user@mail.com",
                "1234",
                "firstname",
                "lastname",
                "address",
                "2021:05:31"
        );
        // pass the user repository as dependency injection

        userService = new UserService(userRepository);
    }

    @Test
    void test_user_request() throws ParseException {
        System.out.println("Print User Request ");

        User user = userService.createUser(userRequest);

        Assert.assertEquals(user.getUsername(),"user1");
        Assert.assertEquals(user.getEmail(),"user@mail.com");
        Assert.assertNotEquals(Arrays.toString(user.getPassword()),"1234");

    }
}
