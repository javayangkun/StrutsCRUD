package com.struts2crud.service;

import java.util.List;

import com.struts2crud.bean.Page;
import com.struts2crud.bean.User;

public interface IUserService {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	List<User> find();
	User find(Integer id);
	Page<User> findPageData(int p, int size);
}
