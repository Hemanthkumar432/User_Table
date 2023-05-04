package com.user.table.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.table.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
