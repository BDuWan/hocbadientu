package com.duwan.hocba.interfac;

import java.util.List;

import com.duwan.hocba.object.HocSinh;

public interface HocSinhInterface {
	public abstract int getHocSinhIdByTDN(String tendangnhap);
	public abstract HocSinh getHocSinhById(int hocsinh_id);
	public abstract List<HocSinh> getListHocSinhByLop(int lop_id);
}
