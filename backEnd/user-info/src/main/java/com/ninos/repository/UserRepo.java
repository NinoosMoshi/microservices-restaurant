package com.ninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
