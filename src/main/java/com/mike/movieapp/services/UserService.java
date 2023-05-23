package com.mike.movieapp.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mike.movieapp.models.LoginUser;
import com.mike.movieapp.models.User;
import com.mike.movieapp.repositories.UserRepository;


@Service
public class UserService {

	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User createUser(User registeringUser,  BindingResult result){
		String hashed = BCrypt.hashpw(registeringUser.getPassword(), BCrypt.gensalt());
		User potentialUser = getUser(registeringUser.getEmail());
		if(potentialUser != null) {
			result.rejectValue("email", "Unique" ,"Email is already in use.");
			return null;
		}
		if(!registeringUser.getPassword().equals(registeringUser.getConfirm())) {
			result.rejectValue("password", "Match", "Passwords dont match.");
			return null;
		}
		registeringUser.setPassword(hashed);
		return userRepo.save(registeringUser);
	}
	
	public User getUser(String email) {
		Optional<User> potentialUser = userRepo.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
	
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	public User getOne(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		if(result.hasErrors()) {
			result.rejectValue("email", "Unique", "Credentials do not match an existing user.");
			return null;
		}
		User existingUser = getUser(loginUser.getEmail());
		if(existingUser == null) {
			result.rejectValue("email", "Unique", "Credentials do not match an existing user.");
			return null;
		}
		if(!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
			result.rejectValue("email", "Unique", "Credentials do not match an existing user.");
			return null;
		}
		
		return existingUser;
	}

}