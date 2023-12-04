package com.duwan.hocba.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.jdbc.core.RowMapper;
import com.duwan.hocba.object.UserObject;

public class UserRowMapper implements RowMapper<UserObject> {
 
	@Override
	public UserObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserObject user = new UserObject();
		user.setTendangnhap(rs.getString("user_tendangnhap"));
		user.setPassword(rs.getString("user_password"));
		user.setHoten(rs.getString("user_hoten"));
		user.setDiachi(rs.getString("user_diachi"));
		user.setSdt(rs.getString("user_sdt"));
		user.setLoaitk(rs.getString("user_loaitk"));
		return user;
	}
}