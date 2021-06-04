package com.llazar.user_service.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dummy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;

    @NotEmpty
    @Size(max = 30)
    private String username;
    @NotEmpty
    @Size(max=30)
    private String email;

    public Dummy(String username,String email)
    {
        this.username = username;
        this.email = email;
    }
}
