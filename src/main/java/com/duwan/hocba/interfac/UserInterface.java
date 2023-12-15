package com.duwan.hocba.interfac;

import java.util.List;

import com.duwan.hocba.object.UserObject;

public interface UserInterface {
	public abstract UserObject getUserByTendangnhap(String user_tendangnhap);
	public abstract List<UserObject> getAllUser();
}
