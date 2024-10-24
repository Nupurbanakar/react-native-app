package com.form.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.form.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
