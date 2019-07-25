package com.afan.manage_cms.controller;

import com.afan.api.cms.CmsPageControllerApi;
import com.afan.common.model.response.CommonCode;
import com.afan.common.model.response.QueryResponseResult;
import com.afan.common.model.response.QueryResult;
import com.afan.domain.cms.CmsPage;
import com.afan.domain.cms.request.QueryPageRequest;
import com.afan.domain.cms.response.CmsPageResult;
import com.afan.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CmsPageController
 * @Description: 控制类
 * @Author：afan
 * @Date : 2019/7/18 21:24
 */
@RestController
@RequestMapping("/cms")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
	private CmsPageService cmsPageService;

	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable  int page,@PathVariable int size, QueryPageRequest
			queryPageRequest) {
		QueryResponseResult pageList = cmsPageService.findList(page, size, queryPageRequest);
		return pageList;
	}

	@Override
	public CmsPageResult addPage(CmsPage cmsPage) {
		return null;
	}
}
