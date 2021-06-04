package com.llazar.user_service.service;


import javax.validation.constraints.NotBlank;


public class UserRequest {


    @NotBlank
    public final String username;

    @NotBlank
    public final String email;

    @NotBlank
    public final String password;

    @NotBlank
    public final String firstname;

    @NotBlank
    public final String lastname;

    @NotBlank
    public final String address;

    @NotBlank
    public final String birthday;

    public UserRequest(String username,
                       String email,
                       String password,
                       String firstname,
                       String lastname,
                       String address,
                       String birthday)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", firstName='" + firstname + '\''
                + ", lastName='" + lastname + '\''
                + ", birthday='" + birthday + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
