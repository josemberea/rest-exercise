package com.innocv.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.innocv.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
		List<User> findAll();
}
