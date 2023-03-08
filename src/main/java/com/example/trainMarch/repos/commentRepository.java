package com.example.trainMarch.repos;

import com.example.trainMarch.entities.comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentRepository extends JpaRepository<comment,Long> {
}
