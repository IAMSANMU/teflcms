package com.tefl.system.menu;

import com.tefl.component.base.BaseProjectModel;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "sys_menu")
public class SysMenu extends BaseProjectModel<SysMenu> {

	private static final long serialVersionUID = 1L;
	public static final SysMenu dao = new SysMenu();

}