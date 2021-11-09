package com.rafadev.srpingmongod.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafadev.srpingmongod.domain.Post;
import com.rafadev.srpingmongod.repository.PostRepository;
import com.rafadev.srpingmongod.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {

		Optional<Post> post = repo.findById(id);

		if (post.isEmpty()) {
			throw new ObjectNotFoundException("Objecto não encontrado");
		}

		return post.get();
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

}
