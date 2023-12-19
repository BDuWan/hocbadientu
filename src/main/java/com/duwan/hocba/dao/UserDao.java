package com.duwan.hocba.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duwan.hocba.object.UserObject;
import com.duwan.hocba.rowmapper.UserRowMapper;

@Repository
public class UserDao extends JdbcDao {
	public UserObject getUserByTendangnhap(String user_tendangnhap) {
		String SQL = "SELECT * FROM user WHERE user_tendangnhap = ?";
		return getJdbcTemplate().queryForObject(SQL, new UserRowMapper(), user_tendangnhap);
	}

//	@Override
//	public List<UserObject> fetchUserByTendangnhap(String user_tendangnhap) {
//		String SQL = "SELECT * FROM user WHERE user_tendangnhap = ?";
//		return getJdbcTemplate().query(SQL, new UserRowMapper(), user_tendangnhap);
//	}
	
	public List<UserObject> getAllUser() {
		String SQL = "SELECT * FROM user";
		return getJdbcTemplate().query(SQL, new UserRowMapper());
	}
}
