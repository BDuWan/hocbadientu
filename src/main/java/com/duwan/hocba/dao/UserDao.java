package com.duwan.hocba.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.duwan.hocba.interfac.UserInterface;
import com.duwan.hocba.object.UserObject;

@Repository
public class UserDao implements UserInterface {
	@Autowired	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public UserObject fetchUserByTendangnhap(String user_tendangnhap) {
		System.out.println(getJdbcTemplate().getDataSource().getClass().getName());
		String SQL = "SELECT * FROM user WHERE user_tendangnhap = ?";
		return getJdbcTemplate().queryForObject(SQL, new UserRowMapper(), user_tendangnhap);
	}

//	@Override
//	public List<UserObject> fetchUserByTendangnhap(String user_tendangnhap) {
//		String SQL = "SELECT * FROM user WHERE user_tendangnhap = ?";
//		return getJdbcTemplate().query(SQL, new UserRowMapper(), user_tendangnhap);
//	}
	
	@Override
	public List<UserObject> fetchAllUser() {
		String SQL = "SELECT * FROM user";
		return getJdbcTemplate().query(SQL, new UserRowMapper());
	}
}
