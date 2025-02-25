package com.example.BlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.Model.Post;
import com.example.BlogApplication.Service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService service;
	@GetMapping
	public List<Post> getAllPost() {
		return service.getAllPost();
	}
	@PostMapping("/add/{uid}")
	public String addAllPost(@PathVariable int uid ,@RequestBody Post post) {
		service.addAllPost(uid, post);
		return "Post Add Successfully";
	}
    
	@GetMapping("/{id}")
	public Post getPostById(@PathVariable int id) {
		return service.getPostById(id);
	}
	@GetMapping("/user/{uid}")
	public List<Post> getPostByUserId(@PathVariable int uid) {
		return service.getPostByUserId(uid);
	}
	@PutMapping("/{pid}")
	public String updatePostbyid(@PathVariable int pid,@RequestBody Post post) {
		service.updatePostbyid(pid,post);
		return "Update successfully!!!";
	}
	@DeleteMapping("/delete/{pid}")
	public String deletePostById(@PathVariable int pid) {
		try {
	        service.deletePostById(pid);   
	        return "Post Deleted Successfully!";
	    } catch (Exception e) {
	        return "Error deleting post: " + e.getMessage();
	    }
	}
}
