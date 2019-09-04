package com.afan.api.cms;


import com.afan.common.model.response.QueryResponseResult;
import com.afan.domain.cms.CmsPage;
import com.afan.domain.cms.request.QueryPageRequest;
import com.afan.domain.cms.response.CmsPageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    //页面查询
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("添加页面")
    public CmsPageResult addPage(@RequestBody CmsPage cmsPage);

    public CmsPageResult findPageById(String id);

    @ApiOperation("发布页面")
    public CmsPageResult post(String pageId);
}
