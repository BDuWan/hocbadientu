package com.duwan.hocba.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.duwan.hocba.object.HocSinhObject;
public class HocSinhRowMapper implements RowMapper<HocSinhObject> {
	@Override
	public HocSinhObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		HocSinhObject hSinh = new HocSinhObject();
		hSinh.setHocsinh_id(rs.getInt("hocsinh_id"));
		hSinh.setLop_id(rs.getString("lop_id"));
		hSinh.setPhuhuynh_id(rs.getInt("phuhuynh_id"));
		hSinh.setUser_tendangnhap(rs.getString("user_tendangnhap"));
		return hSinh;
	}
}
