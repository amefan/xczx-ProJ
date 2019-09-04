package com.afan.mannage_cms_client.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MongoConfig
 * @Description: MongoDb配置类
 * @Author：afan
 * @Date : 2019/8/8 11:34
 */
@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.database}")
	private String db;

	@Bean
	public GridFSBucket gridFSBucket(MongoClient mongoClient){
		MongoDatabase database = mongoClient.getDatabase(db);
		return GridFSBuckets.create(database);
	}
}
