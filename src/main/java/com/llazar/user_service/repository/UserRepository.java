/*
JpaRepository is a JPA specific interface that offers out-of-box implementations for all basic CRUD operations!

This means that you don’t have to define CRUD methods by yourself!

 */

package com.llazar.user_service.repository;

import com.llazar.user_service.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,Long> {
    /**
     * Creates the persistence user repository layer interface.
     */

    UserModel findByUsername(String username);

}
