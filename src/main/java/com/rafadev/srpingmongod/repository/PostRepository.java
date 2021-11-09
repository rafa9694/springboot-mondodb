package com.rafadev.srpingmongod.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafadev.srpingmongod.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable> {

	List<Post> findByTitleContainingIgnoreCase(String text);
}
