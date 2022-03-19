package com.training.jwa.dao;

import java.util.List;

import com.training.ers.model.Users;

public interface LoginDAO {
	
	public boolean register(Users user);
	public boolean validate(String username, String password);
	public List<Users> getUsers();
	public List<Users> getUsersByUserName(String username);
	//public boolean checkEmployee(String username);
	//public boolean checkCustomer(String username);
}
