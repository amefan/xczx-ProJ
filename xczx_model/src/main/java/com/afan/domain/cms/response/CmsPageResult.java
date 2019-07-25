package com.afan.domain.cms.response;


import com.afan.common.model.response.ResponseResult;
import com.afan.common.model.response.ResultCode;
import com.afan.domain.cms.CmsPage;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode, CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
