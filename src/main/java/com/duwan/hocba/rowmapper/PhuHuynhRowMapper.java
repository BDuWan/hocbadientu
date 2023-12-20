package com.duwan.hocba.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.duwan.hocba.object.PhuHuynhObject;

public class PhuHuynhRowMapper implements RowMapper<PhuHuynhObject>{

	@Override
	public PhuHuynhObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		PhuHuynhObject ph = new PhuHuynhObject();
		ph.setPhuhuynh_id(rs.getInt("phuhuynh_id"));
		ph.setTendangnhap(rs.getString("user_tendangnhap"));
		ph.setTendangnhap(rs.getString("user_tendangnhap"));
		ph.setPassword(rs.getString("user_password"));
		ph.setHoten(rs.getString("user_hoten"));
		ph.setDiachi(rs.getString("user_diachi"));
		ph.setSdt(rs.getString("user_sdt"));
		ph.setEmail(rs.getString("user_email"));
		ph.setNgaysinh(rs.getDate("user_ngaysinh"));
		ph.setLoaitk(rs.getString("user_loaitk"));
		ph.setGioitinh(rs.getInt("user_gioitinh"));
		return ph;
	}
}
