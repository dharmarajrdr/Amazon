package com.dharmaraj.e_commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.e_commerce.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findById(int userId);

    public User save(User user);

    public void deleteAll();

    public Optional<User> findUserByEmail(String email);
}
