package com.tefl.modules.admin.school;

import com.jfinal.plugin.activerecord.Page;
import com.tefl.component.base.BaseProjectController;
import com.tefl.component.util.JFlyFoxUtils;
import com.tefl.jfinal.component.annotation.ControllerBind;
import com.tefl.jfinal.component.db.SQLUtils;
import com.tefl.modules.admin.article.ArticleService;
import com.tefl.modules.admin.article.TbArticle;
import com.tefl.util.StrUtils;

@ControllerBind(controllerKey = "/admin/school")
public class SchoolController extends BaseProjectController{

	private static final String path = "/pages/admin/school/school_";
	
	public void list() {
		TbSchool model = getModelByAttr(TbSchool.class);

		SQLUtils sql = new SQLUtils(" from tb_school t " );
				
		if (model.getAttrValues().length != 0) {
			sql.setAlias("t");
			// 查询条件
			sql.whereLike("name", model.getStr("name"));
		}
		// 站点设置

		// 排序
		String orderBy = getBaseForm().getOrderBy();
		if (StrUtils.isEmpty(orderBy)) {
			sql.append(" order by t.id desc ");
		} else {
			sql.append(" order by ").append(orderBy);
		}

		Page<TbSchool> page = TbSchool.dao.paginate(getPaginator(), "select t.* ", //
				sql.toString().toString());
		setAttr("page", page);
		setAttr("attr", model);
		render(path + "list.html");
	}
	
	
	public void add() {
		// 查询下拉框
		render(path + "add.html");
	}

	public void delete() {
		TbSchool model = TbSchool.dao.findById(getParaToInt());
		String now = getNow();
		model.put("update_time", now);
		model.set("is_deleted",JFlyFoxUtils.IS_DELETED_YES);
		model.update();

		list();
	}

	public void edit() {
		TbSchool model = TbSchool.dao.findById(getParaToInt());

		setAttr("model", model);
		render(path + "edit.html");
	}

	public void edit_content_ue() {
		TbSchool model = TbSchool.dao.findById(getParaToInt());
		setAttr("model", model);
		super.render(path + "edit_content_ue.html");
	}
	
	public void save() {
		Integer pid = getParaToInt();
		TbSchool model = getModel(TbSchool.class);

		String now = getNow();
		model.put("update_time", now);
		if (pid != null && pid > 0) { // 更新
			model.update();
		} else { // 新增
			model.remove("id");
			model.set("is_deleted",JFlyFoxUtils.IS_DELETED_NO);
			model.put("create_time", now);
			model.save();
		}
		renderMessage("保存成功");
	}
}
