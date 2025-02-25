package com.example.BlogApplication.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogApplication.Model.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Integer> {
}
