package com.afan.mannage_cms_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: MannageCmsClientApplication
 * @Description: 启动类
 * @Author：afan
 * @Date : 2019/8/6 20:42
 */
@SpringBootApplication
@EntityScan("com.afan.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"com.afan.mannage_cms_client"} ) // 扫描当前项目下
@ComponentScan(basePackages = {"com.afan.common"} ) // 扫描common下的类
public class MannageCmsClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(MannageCmsClientApplication.class,args);
	}
}
