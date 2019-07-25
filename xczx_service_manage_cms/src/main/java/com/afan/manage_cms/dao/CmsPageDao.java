package com.afan.manage_cms.dao;

import com.afan.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description: Cms数据库访问层
 * @author: afan
 */
public interface CmsPageDao extends MongoRepository<CmsPage,String> {

	CmsPage findCmsPageByPageNameAndPageWebPath(String name ,String path);
}
