package com.tefl.system.dict;

import com.tefl.component.base.BaseProjectModel;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "sys_dict", key = "dict_id")
public class SysDict extends BaseProjectModel<SysDict> {

	private static final long serialVersionUID = 1L;
	public static final SysDict dao = new SysDict();

}