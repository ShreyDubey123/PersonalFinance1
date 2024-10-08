package com.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.entity.UserRegistry;

public interface UserRegistryRepository extends CrudRepository<UserRegistry, Integer> {

	@Query("SELECT u FROM UserRegistry u WHERE u.email = :email AND u.password = :password")
    UserRegistry findByEmailAndPassword(String email, String password);
}
