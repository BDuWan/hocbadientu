package com.duwan.hocba.object;

public class UserObject {
	protected String tendangnhap;
	protected String password;
	protected String hoten;
	protected String sdt;
	protected String diachi;
	protected String loaitk;
	public UserObject() {
	}
	
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getLoaitk() {
		return loaitk;
	}
	public void setLoaitk(String loaitk) {
		this.loaitk = loaitk;
	}
	
	@Override
	public String toString() {
		return "User [Tendangnhap=" + tendangnhap + ", password=" + password + ", hoten=" + hoten
				+ ", sdt=" + sdt + ", diachi=" + diachi + "]";
	}
}
