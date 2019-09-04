package com.afan.api.course;

import com.afan.common.model.response.QueryResponseResult;
import com.afan.common.model.response.ResponseResult;
import com.afan.domain.course.Teachplan;
import com.afan.domain.course.ext.TeachplanNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

/**
 * Created by Administrator.
 */

@Api(value="课程管理接口",description = "课程管理接口，提供课程的增、删、改、查")
@CrossOrigin
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("查询我的课程")
    public QueryResponseResult findBaseCourseList(int page, int size);
}