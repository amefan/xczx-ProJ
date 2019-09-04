package com.afan.manage_course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: ManageCourseApplocation
 * @Description: 启动类
 * @Author：afan
 * @Date : 2019/8/12 20:59
 */
@SpringBootApplication
@EntityScan("com.afan.domain.course")//扫描实体类
@MapperScan(basePackages = {"com.afan.manage_course.dao"} )
@ComponentScan(basePackages={"com.afan.api"})//扫描接口
@ComponentScan(basePackages={"com.afan.manage_course"})
@ComponentScan(basePackages={"com.afan.common"})//扫描common下的所有类
public class ManageCourseApplocation {
	public static void main(String[] args) {
		SpringApplication.run(ManageCourseApplocation.class,args);
	}
}
