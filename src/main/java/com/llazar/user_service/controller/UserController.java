package com.llazar.user_service.controller;


import com.llazar.user_service.model.UserModel;
import com.llazar.user_service.service.UserRequest;
import com.llazar.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
public class UserController {



    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public ResponseEntity<String> users(@Valid @RequestBody UserRequest request){

        // ToDo create another service for password verification,validation
        // In a service we do not have the user directly in the arguments

        // but we have the request from another service

        // check if password is equal to password repeat maybe
        // check if email is already in repo
        if (userService.findByUsername(request.getUsername()) != null) {
            return new ResponseEntity<>(
                    "Error: Username already exists.", HttpStatus.BAD_REQUEST);
        }
        try{
            UserModel userModel = userService.save(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
           System.out.println("Failed to create new user");
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {

        String jsonToken = userService.loginByUsernameAndPassword(username,password);

        if (jsonToken.contains("Error:")) {
            return new ResponseEntity<>(jsonToken, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(jsonToken, HttpStatus.OK);
    }


    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }


}
