package com.afan.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * @ClassName: ManageCmsApplication
 * @Description: 启动类
 * @Author：afan
 * @Date : 2019/7/18 20:27
 */
@SpringBootApplication
@EntityScan("com.afan.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"com.afan.api"}) //扫描api接口
@ComponentScan(basePackages = {"com.afan.manage_cms"} ) // 扫描当前项目下
public class ManageCmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ManageCmsApplication.class,args);
	}
}
