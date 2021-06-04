package com.llazar.user_service.repository;

import com.llazar.user_service.model.Dummy;
import com.llazar.user_service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface DummyRepo extends CrudRepository {
    Dummy findFirstByUsername(String username);
}
