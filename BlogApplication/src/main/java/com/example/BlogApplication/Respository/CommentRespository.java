package com.example.BlogApplication.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogApplication.Model.Comment;

@Repository
public interface CommentRespository extends JpaRepository<Comment, Integer> {

}
