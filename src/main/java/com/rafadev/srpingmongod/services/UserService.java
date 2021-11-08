package com.rafadev.srpingmongod.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafadev.srpingmongod.domain.User;
import com.rafadev.srpingmongod.dto.UserDTO;
import com.rafadev.srpingmongod.repository.UserRepository;
import com.rafadev.srpingmongod.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {

		Optional<User> user = repo.findById(id);

		if (user.isEmpty()) {
			throw new ObjectNotFoundException("Objecto não encontrado");
		}

		return user.get();
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
