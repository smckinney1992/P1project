package com.training.jwa.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.ers.model.Users;

class LoginDAOImplTest {
	
	LoginDAO loginDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		loginDAO = new LoginDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*@Test
	void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	void testValidate() {
		fail("Not yet implemented");
	}*/

	@Test
	void testGetUsers() {
		List<Users> uList = loginDAO.getUsers();
		
			for(Users obj : uList)
				System.out.println(obj);
			
			assertTrue(uList.size() == 2 );
	}

}
