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
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;

    @NotEmpty
    @Size(max = 30)
    private String username;
    @NotEmpty
    @Size(max=30)
    private String email;
    private byte[] password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String address;
    private Date birthday;

    public User(String username, String email, byte[] password, String firstName, String lastName, String address, Date birthday) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
    }


}
