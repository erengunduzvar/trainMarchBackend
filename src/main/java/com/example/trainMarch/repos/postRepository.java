package com.example.trainMarch.repos;

import com.example.trainMarch.entities.post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface postRepository extends JpaRepository<post,Long> {

    List<post> findByUserId(Long userId);
}
