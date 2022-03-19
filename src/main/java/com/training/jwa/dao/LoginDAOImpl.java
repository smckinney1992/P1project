package com.training.jwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.ers.model.Users;
import com.training.jwa.utility.DBConnection;

public class LoginDAOImpl implements LoginDAO {
	
	private static Logger logger = Logger.getLogger(LoginDAOImpl.class);
	Connection connection = DBConnection.getConnection();
	//Creates a new account
	@Override
	public boolean register(Users user) {
		System.out.println("##Adding user :" + user);
		PreparedStatement statement = null;
		int rows = 0;
		try {
				statement = connection.prepareStatement("insert into users values(default,?,?,?,?,?)");
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getGender());
				statement.setString(4, user.getNotification());
				statement.setString(5, user.getQualification());
				
				rows = statement.executeUpdate();
				System.out.println(rows + " user registered successfully");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rows == 0)
			return false;
		else
			return true;
	}
	
	//confirms that the account exists
	@Override
	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
				//if() {
					
				//} else {
				stat = connection.prepareStatement("select * from users where username = ? and password = ? ");
				stat.setString(1, username);
				stat.setString(2, password);
				
				ResultSet res = stat.executeQuery();
				userValid = res.next();//}
				if(userValid) {
		            logger.info(username + " logged in successfully");
		        } else {
		            logger.warn(username + " attempted to log in");
		        }
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userValid;
	}
	@Override
	public List<Users> getUsers(){
		System.out.println("##Printing all users ");
		List<Users> users = new ArrayList<Users>();
		
		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from users");
			while(res.next()) {
				Users user = new Users();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setGender(res.getString(4));
				user.setNotification(res.getString(5));
				user.setQualification(res.getString(6));
				users.add(user);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	@Override
	public List<Users> getUsersByUserName(String username) {
	System.out.println("##Printing search users ");
	List<Users> users = new ArrayList<Users>();
	
	Statement stat;
	try {
		stat = connection.createStatement();
		ResultSet res = stat.executeQuery("select * from users where username = '"+username+"'");
		while(res.next()) {
			Users user = new Users();
			user.setUserId(res.getInt(1));
			user.setUsername(res.getString(2));
			user.setPassword(res.getString(3));
			user.setGender(res.getString(4));
			user.setNotification(res.getString(5));
			user.setQualification(res.getString(6));
			users.add(user);
			
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return users;
}
	//Checks employee table if account exists
//	public boolean checkEmployee(String username) {
//		boolean employee = false;
//		PreparedStatement statement;
//		try {
//			//statement = connection.prepareStatement("select * from employee where username = ?");
//			statement = connection.prepareStatement("select * from employees where username = ?");
//			statement.setString(1, username);
//			ResultSet res = statement.executeQuery();
//			//res.next();
//			employee = res.next();
//			//res.close();
//			//statement.close();
//			//connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return employee;
//	}
//	//Checks customer table if account exists
//	public boolean checkCustomer(String username){
//		boolean customer = false;
//		PreparedStatement statement;
//		try {
//			statement = connection.prepareStatement("select * from customer where username = ?");
//			statement.setString(1, username);
//			ResultSet res = statement.executeQuery();
//			//res.next();
//			customer = res.next();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return customer; 
//		}
	}

