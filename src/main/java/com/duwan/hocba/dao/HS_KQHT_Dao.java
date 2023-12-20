package com.duwan.hocba.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duwan.hocba.object.HS_KQHT_Object;
import com.duwan.hocba.rowmapper.HS_KQHT_RowMapper;

@Repository
public class HS_KQHT_Dao extends JdbcDao {
	public List<HS_KQHT_Object> getKqhtByHocSinhId(int id) {
		String SQL = "select *  from ketquahoctap "
				+ " JOIN monhoc on monhoc.monhoc_id = ketquahoctap.monhoc_id"
				+ " where ketquahoctap.hocsinh_id = ?";
		return getJdbcTemplate().query(SQL, new HS_KQHT_RowMapper(), id	);
	}
	
	public List<HS_KQHT_Object> getKqhtByHocSinhId(int id, int ki) {
		String SQL = "select * from ketquahoctap "
				+ " JOIN monhoc on monhoc.monhoc_id = ketquahoctap.monhoc_id"
				+ " where ketquahoctap.hocsinh_id = ? and ketquahoctap.hocki = ?";
		return getJdbcTemplate().query(SQL, new HS_KQHT_RowMapper(), id	, ki);
	}

}
