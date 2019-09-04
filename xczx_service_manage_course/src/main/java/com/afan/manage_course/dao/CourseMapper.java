package com.afan.manage_course.dao;

import com.afan.domain.course.CourseBase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator.
 */
@Mapper
@Repository
public interface CourseMapper {
   CourseBase findCourseBaseById(String id);
}
