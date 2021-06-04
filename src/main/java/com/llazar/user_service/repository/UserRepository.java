/*
JpaRepository is a JPA specific interface that offers out-of-box implementations for all basic CRUD operations!

This means that you don’t have to define CRUD methods by yourself!

 */

package com.llazar.user_service.repository;

import com.llazar.user_service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findFirstByUsername(String username);
    Boolean existUsername(String username);
    Boolean existEmail(String email);

}
