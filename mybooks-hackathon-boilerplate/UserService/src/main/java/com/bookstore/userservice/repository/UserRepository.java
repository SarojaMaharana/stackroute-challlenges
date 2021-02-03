package com.bookstore.userservice.repository;

import com.bookstore.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findByUserIdAndPassword(String userId, String password);
}
