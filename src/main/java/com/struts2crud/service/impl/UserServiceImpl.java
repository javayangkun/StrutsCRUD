package com.struts2crud.service.impl;

import java.util.List;

import com.struts2crud.bean.Page;
import com.struts2crud.bean.User;
import com.struts2crud.dao.impl.UserDaoImpl;
import com.struts2crud.service.IUserService;

public class UserServiceImpl implements IUserService {
	private static UserDaoImpl UserDao = new UserDaoImpl();

	@Override
	public void save(User user) {
		UserDao.save(user);
	}

	@Override
	public void delete(Integer id) {
		UserDao.delete(id);
	}

	@Override
	public void update(User user) {
		UserDao.update(user);
	}

	@Override
	public List<User> find() {
		return UserDao.find();
	}

	@Override
	public User find(Integer id) {
		return UserDao.find(id);
	}

	//��ʼ��page����,��װ��Ϣ.
	@Override
	public Page<User> findPageData(int p, int size) {
		int rowCount = UserDao.getRowCount();
		Page<User> page = new Page<User>(p, rowCount, size);
		//ҵ��㱾�����ǵ���dao��ķ�����,�������װÿһ�ε�page����
		List<User> list = UserDao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
