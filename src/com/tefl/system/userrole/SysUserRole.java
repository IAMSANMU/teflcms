package com.tefl.system.userrole;

import com.tefl.component.base.BaseProjectModel;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "sys_user_role")
public class SysUserRole extends BaseProjectModel<SysUserRole> {

	private static final long serialVersionUID = 1L;
	public static final SysUserRole dao = new SysUserRole();

}