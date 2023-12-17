package com.duwan.hocba.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.duwan.hocba.interfac.HocSinhInterface;
import com.duwan.hocba.object.HocSinhObject;
import com.duwan.hocba.rowmapper.HocSinhRowMapper;

@Repository
public class HocSinhDao implements HocSinhInterface {
	@Autowired	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public HocSinhObject getHocSinhByTDN(String tendangnhap) {
		String SQL = "SELECT * FROM hocsinh WHERE user_tendangnhap = ?";
		return getJdbcTemplate().queryForObject(SQL, new HocSinhRowMapper(), tendangnhap);
	}
}
