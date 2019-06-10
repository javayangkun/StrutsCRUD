package com.struts2crud.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.struts2crud.bean.User;
import com.struts2crud.service.impl.UserServiceImpl;

public class TestAll {
	private static UserServiceImpl UserService = new UserServiceImpl();
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		List<User> users = UserService.find();
		System.out.println(users);
	}

	@Test
	public void testFindInteger() {
		User user = UserService.find(1);
		System.out.println(user);
	}

	@Test
	public void testGetRowCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindIntInt() {
		fail("Not yet implemented");
	}

}
