package com.example.mobile.repostories;

import com.example.mobile.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}
