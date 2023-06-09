package com.mike.movieapp.models;

import jakarta.validation.constraints.Email;

public class LoginUser {
	
	
    @Email
    private String email;
    
    private String password;
    
    public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

