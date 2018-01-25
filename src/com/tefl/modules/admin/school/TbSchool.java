package com.tefl.modules.admin.school;

import com.tefl.component.base.BaseProjectModel;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "tb_school", key = "id")
public class TbSchool extends BaseProjectModel<TbSchool>{
	private static final long serialVersionUID = 1L;
	public static final TbSchool dao = new TbSchool();
}
