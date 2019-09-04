package com.afan.manage_cms.service;

import com.afan.common.Exception.ExceptionCast;
import com.afan.common.Exception.ExceptionCatch;
import com.afan.common.model.response.CommonCode;
import com.afan.common.model.response.QueryResponseResult;
import com.afan.common.model.response.QueryResult;
import com.afan.domain.cms.CmsPage;
import com.afan.domain.cms.request.QueryPageRequest;
import com.afan.domain.cms.response.CmsCode;
import com.afan.domain.cms.response.CmsPageResult;
import com.afan.manage_cms.dao.CmsPageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName: CmsPageService
 * @Description: TODO
 * @Author：afan
 * @Date : 2019/7/19 17:04
 */
@Service
public class CmsPageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CmsPageService.class);

	@Autowired
	private CmsPageDao cmsPageDao;

	public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){
		if(page <= 0){
			page = 1;
		}
		page = page -1 ; //适应mongodb的分页
		Pageable pageable = PageRequest.of(page, size);
		Page<CmsPage> pageList = cmsPageDao.findAll(pageable);
		QueryResult<CmsPage> queryResult = new QueryResult<>();
		queryResult.setList(pageList.getContent());
		queryResult.setTotal(pageList.getTotalElements());

		return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
	}

	/**
	 * @Description: 添加页面
	 * @author: afan
	 * @param: [cmsPage]
	 * @return: com.afan.domain.cms.response.CmsPageResult
	 */
   public CmsPageResult addPage(CmsPage cmsPage){
	   CmsPage page = cmsPageDao.findCmsPageByPageNameAndPageWebPath(cmsPage.getPageName(),
			   cmsPage.getPageWebPath());
	   if (page == null) {
		   //主键自动生成
		   cmsPage.setPageId(null);
		   cmsPageDao.save(cmsPage);
		   return new CmsPageResult(CommonCode.SUCCESS,null);
	   }

	   return new CmsPageResult(CommonCode.FAIL, null);
   }

	public CmsPageResult findPageById(String id) {
		Optional<CmsPage> cmsPage = cmsPageDao.findById(id);
		if(!cmsPage.isPresent()){

			ExceptionCast.cast(CmsCode.CMS_ADDPAGE_NOTEXISTS);
		}
		return new CmsPageResult(CommonCode.SUCCESS,cmsPage.get());
	}
}
