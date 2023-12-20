package com.duwan.hocba.rowmapper;
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
		user.setEmail(rs.getString("user_email"));
		user.setNgaysinh(rs.getDate("user_ngaysinh"));
		user.setLoaitk(rs.getString("user_loaitk"));
		user.setGioitinh(rs.getInt("user_gioitinh"));
		return user;
	}
}