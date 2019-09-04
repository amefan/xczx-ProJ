package com.afan.mannage_cms_client.mq;

import com.afan.domain.cms.CmsPage;
import com.afan.mannage_cms_client.dao.CmsPageRepository;
import com.afan.mannage_cms_client.service.PageService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: ConsumerPostPage
 * @Description: RabbitMq消费者
 * @Author：afan
 * @Date : 2019/8/8 9:28
 */
@Component
public class ConsumerPostPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerPostPage.class);

	@Autowired
	private CmsPageRepository cmsPageRepository;
	@Autowired
	private PageService pageService;

	@RabbitListener(queues = {"${afan.config.queue}"})
	public void postPage(String msg){
		// 解析消息
		Map map = JSON.parseObject(msg, Map.class);
		LOGGER.info("receive cms post page:{}",map.toString());
		// 取出页面Id
		String pageId = (String) map.get("pageId");
		// 查询页面消息
		Optional<CmsPage> byId = cmsPageRepository.findById(pageId);
		if (byId.isPresent()) {
			LOGGER.error("page is null:{}",pageId);
			return ;
		}
		pageService.savePageToServerPath(pageId);
	}


}
