package com.afan.mannage_cms_client.dao;

import com.afan.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: CmsSiteRepository
 * @Description: TODO
 * @Author：afan
 * @Date : 2019/8/7 16:22
 */
public interface  CmsSiteRepository extends MongoRepository<CmsSite,String> {
}
