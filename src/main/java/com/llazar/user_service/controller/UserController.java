package com.llazar.user_service.controller;


import com.llazar.user_service.Service.UserRequest;
import com.llazar.user_service.Service.UserService;
import com.llazar.user_service.model.User;
import com.llazar.user_service.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
public class UserController {
    private static final Logger LOGGER = LogManager.getLogManager().getLogger(String.valueOf(UserController.class));
    private static final String READINESS_CODE = "ok" ;


    // get the service through dependency injection

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/ready")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> ready() {
        return new ResponseEntity<>(READINESS_CODE, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> users(@Valid @RequestBody UserRequest request){

        // In a service we do not have the user directly in the arguments
        // but we have the request from another server

        // check if password is equal to password repeat

        // check if email is already in repo

       try{
           User user = userService.createUser(request);
           userService.save(user);
           LOGGER.info("Successfully created user: " + user.getEmail());
           return new ResponseEntity<>(HttpStatus.CREATED);
       } catch (Exception e){
           LOGGER.info("Failed to create new user");
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }



}
