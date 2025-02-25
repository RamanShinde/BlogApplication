package com.example.BlogApplication.Service;

import java.util.List;
import java.util.Optional;

import javax.management.JMRuntimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BlogApplication.Model.Post;
import com.example.BlogApplication.Model.User;
import com.example.BlogApplication.Respository.PostRespository;
import com.example.BlogApplication.Respository.UserRespository;

@Service
@Transactional
public class PostService {
	@Autowired
	PostRespository respository;
	@Autowired
	UserRespository userRespository;

	public List<Post> getAllPost() {
		return respository.findAll();
	}

	public void addAllPost(int uid, Post post) {
		User exitinguser = userRespository.findById(uid).orElse(null);
		if (exitinguser != null) {
			post.setUser(exitinguser);
			respository.save(post);
		} else {
			System.out.println("User is not found!!");
		}
	}

	public Post getPostById(int id) {
		return respository.findById(id).orElse(null);
	}

	public List<Post> getPostByUserId(int uid) {
		User user = userRespository.findById(uid)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + uid));
		;
		List<Post> post = user.getPost();
		return post;
	}

	public void updatePostbyid(int pid, Post post) {
		Post extingpost = respository.findById(pid)
				.orElseThrow(() -> new RuntimeException("Post is not found: " + pid));
		extingpost.setContent(post.getContent());
		respository.save(extingpost);
	}
   @Transactional
	public void deletePostById(int pid) {
		  Post post = respository.findById(pid).orElseThrow(()->new JMRuntimeException("Post is not found!!"+pid));
		  respository.delete(post);
	}
}