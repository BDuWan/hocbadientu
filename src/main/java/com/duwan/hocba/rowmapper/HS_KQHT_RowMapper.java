package com.duwan.hocba.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.duwan.hocba.object.HS_KQHT_Object;

public class HS_KQHT_RowMapper implements RowMapper<HS_KQHT_Object> {

	@Override
	public HS_KQHT_Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		HS_KQHT_Object kqht = new HS_KQHT_Object();
		kqht.setDiem(rs.getFloat("diem"));
		kqht.setHocKi(rs.getInt("hocki"));
		kqht.setMonHoc_name(rs.getString("monhoc_name"));
		kqht.setNamHoc(rs.getString("namhoc"));
		kqht.setNhanXet(rs.getString("nhanxetcuagv"));
		return kqht;
	}

}
