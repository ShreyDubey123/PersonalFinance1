package com.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.User;

@RepositoryRestResource(path = "/user")
public interface UserRepository extends CrudRepository<User, Integer> {

}
