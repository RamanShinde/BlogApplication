package com.example.BlogApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BlogApplication.Model.Comment;
import com.example.BlogApplication.Model.Post;
import com.example.BlogApplication.Respository.CommentRespository;
import com.example.BlogApplication.Respository.PostRespository;

@Service
@Transactional
public class CommentService {
	@Autowired
	CommentRespository respository;
	@Autowired
	PostRespository postRespository;

	public List<Comment> getAllComment() {
		return respository.findAll();
	}

	public void addComment(int pid, Comment comment) {
		Optional<Post> extingpost = postRespository.findById(pid);
		if (extingpost.isPresent()) {
			Post post = extingpost.get();
			comment.setPost(post);
			respository.save(comment);
		}
	}

	public void deleteComment(int cid) {
		Comment comment = respository.findById(cid).orElseThrow(() -> new RuntimeException("Comment not found!!"));
        respository.delete(comment);
	}
}