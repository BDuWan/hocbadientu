package com.duwan.hocba.object;

public class HS_KQHT_Object {
	private String namHoc;
	private int hocKi;
	private String monHoc_name;
	private float diem;
	private String nhanXet;
	
	public HS_KQHT_Object() {
		super();
	}
	
	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public int getHocKi() {
		return hocKi;
	}

	public void setHocKi(int hocKi) {
		this.hocKi = hocKi;
	}

	public String getMonHoc_name() {
		return monHoc_name;
	}

	public void setMonHoc_name(String monHoc_name) {
		this.monHoc_name = monHoc_name;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	@Override
	public String toString() {
		return "HS_KQHT_Object [namHoc=" + namHoc + ", hocKi=" + hocKi + ", monHoc_name=" + monHoc_name + ", diem="
				+ diem + ", nhanxet=" + nhanXet + "]";
	}

}
