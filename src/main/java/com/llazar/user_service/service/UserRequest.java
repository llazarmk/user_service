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
    public final String first_name;

    @NotBlank
    public final String last_name;


    public final String address;


    public final String birthday;

    /**
     *  User parameters login request class
     *
     *  @param username string username of the user
     *  @param email string email of the user
     *  @param password string password of the user
     *  @param first_name string first_name of the user
     *  @param last_name string last_name of the user
     *  @param address   string address of the user
     *  @param birthday  string birthday of the user in the form (YY-MM-dd)
     */

    public UserRequest(String username,
                       String email,
                       String password,
                       String first_name,
                       String last_name,
                       String address,
                       String birthday)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", first_name='" + first_name + '\''
                + ", last_name='" + last_name + '\''
                + ", birthday='" + birthday + '\''
                + ", address='" + address + '\''
                + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }
}
