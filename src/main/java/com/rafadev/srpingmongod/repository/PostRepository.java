package com.rafadev.srpingmongod.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rafadev.srpingmongod.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable> {

	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
}
