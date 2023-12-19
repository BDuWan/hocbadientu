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
		hSinh.setTendangnhap(rs.getString("user_tendangnhap"));
		hSinh.setPassword(rs.getString("user_password"));
		hSinh.setHoten(rs.getString("user_hoten"));
		hSinh.setDiachi(rs.getString("user_diachi"));
		hSinh.setSdt(rs.getString("user_sdt"));
		hSinh.setLoaitk(rs.getString("user_loaitk"));
		return hSinh;
	}
}
