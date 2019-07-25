package com.afan.manage_cms;

import com.afan.domain.cms.CmsPage;
import com.afan.domain.cms.CmsPageParam;
import com.afan.manage_cms.dao.CmsPageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName: CmsManageDaoTest
 * @Description: cmsdao单元测试类
 * @Author：afan
 * @Date : 2019/7/19 16:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsManageDaoTest {

	@Autowired
	private CmsPageDao cmsPageDao;

	/**
	 * @Description: 测试分页
	 * @author: afan
	 * @param: []
	 * @return: void
	 */
	@Test
	public void TestPage(){
		int page = 0;
		int size = 2;
		Pageable pageable = PageRequest.of(page, size);
		Page<CmsPage> all = cmsPageDao.findAll(pageable);
		System.out.println(all.getContent().get(0));
	}

	/**
	 * @Description: 添加
	 * @author: afan
	 * @param: []
	 * @return: void
	 */
	@Test
	public void addtest(){
		//定义实体类
		//Object cmsPage;
		CmsPage cmsPage = new CmsPage();
		cmsPage.setSiteId("s01");
		cmsPage.setTemplateId("t01");
		cmsPage.setPageName("测试页面");
		cmsPage.setPageCreateTime(new Date());
		List<CmsPageParam> cmsPageParams = new ArrayList<>();
		CmsPageParam cmsPageParam = new CmsPageParam();
		cmsPageParam.setPageParamName("param1");
		cmsPageParam.setPageParamValue("value1");
		cmsPageParams.add(cmsPageParam);
		cmsPage.setPageParams(cmsPageParams);
		cmsPageDao.save(cmsPage);
		System.out.println(cmsPage);
	}

	@Test
	public void update(){
		Optional<CmsPage> optional = cmsPageDao.findById("5d317e131de9b43470347513");
		if(optional.isPresent()){
			CmsPage cmsPage = optional.get();
			cmsPage.setPageName("测试界面001");
			cmsPageDao.save(cmsPage);
		}
	}

	@Test
	public void delete(){
		cmsPageDao.deleteById("5d317e131de9b43470347513");
	}
}
