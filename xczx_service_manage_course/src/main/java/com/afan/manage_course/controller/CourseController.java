package com.afan.manage_course.controller;


import com.afan.api.course.CourseControllerApi;
import com.afan.common.model.response.QueryResponseResult;
import com.afan.common.model.response.ResponseResult;
import com.afan.domain.course.Teachplan;
import com.afan.domain.course.ext.TeachplanNode;
import com.afan.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController implements CourseControllerApi {

    @Autowired
    CourseService courseService;

    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseService.findTeachplanList(courseId);

    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }

    @Override
    @GetMapping("/coursebase/list/{page}/{size}")
    public QueryResponseResult findBaseCourseList(@PathVariable int page,@PathVariable int size) {
        return courseService.findBaseCourseList(page ,size);
    }
}
