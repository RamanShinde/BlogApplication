package com.example.BlogApplication.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pid;
@Column(nullable = false)
private String title;
@Column(nullable=false)
private String content;

@Column(nullable=false)
@CreationTimestamp
private LocalDateTime createdAt;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="user_Id")
@JsonIgnore
private User user;

@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
@JsonIgnoreProperties("post")
private List<Comment> comment;

}
