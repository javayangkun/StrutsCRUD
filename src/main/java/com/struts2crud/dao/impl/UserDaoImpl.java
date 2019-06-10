package com.struts2crud.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.struts2crud.bean.User;
import com.struts2crud.dao.IUserDao;
import com.struts2crud.util.JdbcUtil;

public class UserDaoImpl implements IUserDao {
	private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

	@Override
	public void save(User user) {
		String sql = "insert into User values(null,?,?,?)";
		jdbcTemplate.update(sql,user.getName(),user.getBirthday(),user.getMoney());
	}

	@Override
	public void update(User user) {
		String sql = "update User set name = ?,birthday = ? money = ? where id = ?";
		jdbcTemplate.update(sql,user.getName(),user.getBirthday(),user.getMoney(),user.getId());
	}

	@Override
	public User find(Integer id) {
		String sql = "select * from User where id = ?";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),id);
		return users!=null?users.get(0):null;
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete * from User where id = ?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public List<User> find() {
		String sql = "select * from User";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}

	@Override
	public int getRowCount() {
		String sql = "select count(id) from user ";
		Long tatalUSers = jdbcTemplate.queryForObject(sql, Long.class);
		return tatalUSers.intValue();
	}

	@Override
	public List<User> find(int startLine, int size) {
		String sql = "select * from User limit ?,?";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),startLine,size);
		return users;
	}

}
