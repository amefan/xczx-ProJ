package com.afan.manage_course.dao;

import com.afan.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
