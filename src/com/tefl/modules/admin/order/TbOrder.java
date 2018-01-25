package com.tefl.modules.admin.order;

import com.tefl.component.base.BaseProjectModel;
import com.tefl.jfinal.component.annotation.ModelBind;

@ModelBind(table = "tb_order", key = "id")
public class TbOrder extends BaseProjectModel<TbOrder>{
	private static final long serialVersionUID = 1L;
	public static final TbOrder dao = new TbOrder();
}
