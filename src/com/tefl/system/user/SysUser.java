package com.tefl.system.user;

import com.tefl.jfinal.base.SessionUser;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "sys_user", key = "userid")
public class SysUser extends SessionUser<SysUser> {

	private static final long serialVersionUID = 1L;
	public static final SysUser dao = new SysUser();
	
}
