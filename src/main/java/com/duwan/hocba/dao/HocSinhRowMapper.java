package com.duwan.hocba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.duwan.hocba.object.HocSinh;
public class HocSinhRowMapper implements RowMapper<HocSinh> {
	@Override
	public HocSinh mapRow(ResultSet rs, int rowNum) throws SQLException {
		HocSinh hSinh = new HocSinh();
		hSinh.setHocsinh_id(rs.getInt("hocsinh_id"));
		hSinh.setLop_id(rs.getInt("lop_id"));
		hSinh.setPhuhuynh_id(rs.getInt("phuhuynh_id"));
		hSinh.setUser_tendangnhap(rs.getString("user_tendangnhap"));
		return hSinh;
	}
}
