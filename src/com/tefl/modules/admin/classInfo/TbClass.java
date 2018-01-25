package com.tefl.modules.admin.classInfo;

import com.tefl.component.base.BaseProjectModel;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "tb_class", key = "id")
public class TbClass extends BaseProjectModel<TbClass>{
	private static final long serialVersionUID = 1L;
	public static final TbClass dao = new TbClass();
}
