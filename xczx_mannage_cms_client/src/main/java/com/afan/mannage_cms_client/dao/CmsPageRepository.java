package com.afan.mannage_cms_client.dao;

import com.afan.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPageRepository extends MongoRepository<CmsPage,String>{
}
