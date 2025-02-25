package com.example.BlogApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BlogApplication.Model.User;
import com.example.BlogApplication.Respository.UserRespository;

@Service
public class UserService {
	@Autowired
	UserRespository respository;
	public List<User> getAllUser() {
		return respository.findAll();
	}
	public void addUser(User user) {
		respository.save(user);
	}
	public User getUserById(int id) {
		return respository.findById(id).orElse(null);
	}
	public void updateUserById(int id,User user) {
		 Optional<User> exstinguser = respository.findById(id);
		 if(exstinguser.isPresent()) {
			 User updateduser=exstinguser.get();
			 updateduser.setEmail(user.getEmail());
			 updateduser.setPassword(user.getPassword());
			 respository.save(updateduser);
		 }
	}
	public void deletUser(int id) {
		 Optional<User> user = respository.findById(id);
		 user.ifPresent(respository:: delete);
	}
}