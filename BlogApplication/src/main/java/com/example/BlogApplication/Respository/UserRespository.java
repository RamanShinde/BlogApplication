package com.example.BlogApplication.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogApplication.Model.User;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {

}
