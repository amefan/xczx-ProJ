package com.afan.manage_course.dao;

import com.afan.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 课程计划mapper
 * Created by Administrator.
 */
@Mapper
@Repository
public interface TeachplanMapper {
    //课程计划查询
    public TeachplanNode selectList(String courseId);
}
