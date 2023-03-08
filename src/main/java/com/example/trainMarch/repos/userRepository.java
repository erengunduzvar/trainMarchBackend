package com.example.trainMarch.repos;

import com.example.trainMarch.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Long> {
}
