package com.rafadev.srpingmongod.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafadev.srpingmongod.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Serializable> {

}
