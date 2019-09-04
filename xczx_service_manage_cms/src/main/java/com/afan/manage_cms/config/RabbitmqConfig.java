package com.afan.manage_cms.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitmqConfig
 * @Description: RabbitMq配置类
 * @Author：afan
 * @Date : 2019/8/6 20:52
 */
@Configuration
public class RabbitmqConfig {
	//队列bean的名字
	private static final String QUEUE_CMS_POSTPAGE = "queue_cms_postpage";
	//交换机
	private static final String EX_ROUTING_CMS_POSTPAGE = "queue_cms_postpage";

	/**
	 * @Description: 配置direct类型的交换机
	 * @author: afan
	 * @return: org.springframework.amqp.core.Exchange
	 */
	@Bean(name = EX_ROUTING_CMS_POSTPAGE)
	public Exchange Exchange_DIRECT_INFORM(){
		// durable(true)交换机持久化，消息队列交换机依然存在
		return ExchangeBuilder.directExchange(EX_ROUTING_CMS_POSTPAGE).durable(true).build();
	}
    

}
