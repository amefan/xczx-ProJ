package com.afan.mannage_cms_client.service;

import com.afan.common.Exception.ExceptionCast;
import com.afan.domain.cms.CmsPage;
import com.afan.domain.cms.CmsSite;
import com.afan.domain.cms.response.CmsCode;
import com.afan.mannage_cms_client.dao.CmsPageRepository;
import com.afan.mannage_cms_client.dao.CmsSiteRepository;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Optional;

/**
 * @ClassName: PageService
 * @Description: TODO
 * @Author：afan
 * @Date : 2019/8/7 18:51
 */
@Service
public class PageService {

	@Autowired
	private CmsPageRepository cmsPageRepository;
	@Autowired
	private CmsSiteRepository cmsSiteRepository;

	@Autowired
	private GridFsTemplate gridFsTemplate;
	@Autowired
	GridFSBucket gridFSBucket;

	//将页面的Html保存到物理界面
	public void savePageToServerPath(String pageId){
		Optional<CmsPage> optional = cmsPageRepository.findById(pageId);
		if(optional.isPresent()){
			ExceptionCast.cast(CmsCode.CMS_ADDPAGE_NOTEXISTS);
		}
		CmsPage cmsPage = optional.get();
		//获取站点
		CmsSite cmsSite = this.getCmsSiteById(cmsPage.getSiteId());
		// 页面物理路径
		String path = cmsSite.getSiteWebPath()+cmsPage.getPagePhysicalPath()+cmsPage.getPageName();
		// 查询静态文件
		String htmlFileId = cmsPage.getHtmlFileId();
		// 获取文件流
		InputStream inputStream = this.getFileById(htmlFileId);
		if(inputStream==null){
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_HTMLISNULL);
		}
		FileOutputStream fileOutputStream = null;
		try{
			fileOutputStream = new FileOutputStream(new File(path));
			IOUtils.copy(inputStream,fileOutputStream);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	// 根据Id获取文件
	public InputStream getFileById(String fileId){
		try {
			com.mongodb.client.gridfs.model.GridFSFile gridFSFiles = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is
					(fileId)));
			GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFiles.getObjectId());
			GridFsResource gridFsResource = new GridFsResource(gridFSFiles, gridFSDownloadStream);
			return gridFsResource.getInputStream();
		}catch (Exception e){
			e.printStackTrace();
		}

			return null;
	}


	//根据站点ID获取站点
	public CmsSite getCmsSiteById(String siteId){
		Optional<CmsSite> optional = cmsSiteRepository.findById(siteId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
