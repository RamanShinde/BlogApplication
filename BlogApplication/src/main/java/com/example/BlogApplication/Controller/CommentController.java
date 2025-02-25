package com.example.BlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.Model.Comment;
import com.example.BlogApplication.Model.Post;
import com.example.BlogApplication.Service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentService service;

	@GetMapping
	List<Comment> getAllComment() {
		return service.getAllComment();
	}

	@PostMapping("/add/{pid}")
	String addComment(@PathVariable int pid, @RequestBody Comment comment) {
		service.addComment(pid,comment);
		return "Add comment succesfully";
	}
	@DeleteMapping("/delete/{cid}")
	String deleteComment(@PathVariable int cid) {
		service.deleteComment(cid);
		return "Delete Successfully!!!";
	}
}
