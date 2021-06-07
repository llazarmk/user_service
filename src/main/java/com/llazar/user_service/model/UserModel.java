/*
 Java persistence and provides an object-relational mapping approach that lets you declaratively
 define how to map Java objects to relational database tables in a standard, portable way
 */

package com.llazar.user_service.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
public class UserModel {

    // ToDo the password is going to be passed through the frontend service so it is going to come hashed+ salted

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userid;

    @NotEmpty
    @Size(max = 30)
    private String username;

    @NotEmpty
    @Size(max=30)
    private String email;


    @NotEmpty
    @Size(max=255)
    private String password;

    @NotEmpty
    @Size(max=30)
    private String first_name;

    @NotEmpty
    @Size(max=30)
    private String last_name;

    @Size(max=100)
    private String address;
    private Date birthday;

    /**
     * Constructs the User Model
     *
     *  @param username string username of the user
     *  @param email string email of the user
     *  @param password string password of the user
     *  @param first_name string first_name of the user
     *  @param last_name string last_name of the user
     *  @param address   string address of the user
     *  @param birthday  string birthday of the user in the form (YY-MM-dd)
     */

    public UserModel(String username, String email, String password, String first_name, String last_name, String address, Date birthday) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.birthday = birthday;
    }


}
