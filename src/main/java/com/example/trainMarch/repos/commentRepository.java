package com.example.trainMarch.repos;

import com.example.trainMarch.entities.comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface commentRepository extends JpaRepository<comment,Long> {

    List<comment> findByUserIdAndPostId(Long postId, Long userId);

    List<comment> findByPostId(Long postId);

    List<comment> findByUserId(Long userId);
}
