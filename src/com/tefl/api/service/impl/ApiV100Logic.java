package com.tefl.api.service.impl;

import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.tefl.api.form.ApiForm;
import com.tefl.api.form.ApiResp;
import com.tefl.api.service.IApiLogic;
import com.tefl.modules.admin.article.TbArticle;
import com.tefl.modules.admin.folder.FolderService;
import com.tefl.modules.admin.folder.TbFolder;
import com.tefl.modules.front.service.FrontCacheService;

/**
 * Api基础方法
 * 
 * 2016年9月29日 上午11:19:00 flyfox 369191470@qq.com
 */
public class ApiV100Logic extends BaseApiLogic implements IApiLogic {

	private FrontCacheService service = new FrontCacheService();
	private FolderService folderServer = new FolderService();

	@Override
	public ApiResp config(ApiForm form) {
		return new ApiResp(form).addData("test", "ok");
	}

	@Override
	public ApiResp folders(ApiForm form) {
		List<TbFolder> list = folderServer.getFolders(form.getInt("siteId"));
		return new ApiResp(form).addData("list", list);
	}

	@Override
	public ApiResp pageArticleSite(ApiForm form) {
		Page<TbArticle> page = service.getArticleBySiteId(form.getPaginator(), form.getInt("siteId"));
		return new ApiResp(form).addData("list", page.getList()).addData("total", page.getTotalRow());
	}

	@Override
	public ApiResp pageArticle(ApiForm form) {
		Page<TbArticle> page = service.getArticle(form.getPaginator(), form.getInt("folderId"));
		return new ApiResp(form).addData("list", page.getList()).addData("total", page.getTotalRow());
	}

	@Override
	public ApiResp article(ApiForm form) {
		TbArticle article = service.getArticle(form.getInt("articleId"));
		return new ApiResp(form).addData("article", article);
	}

}
