package com.afan.mannage_cms_client.config;


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

	// 队列的名字
	@Value("${afan.config.queue}")
	private String queue_cms_postpage_name;

	//routingKey
	@Value("${afan.config.routingkey}")
	private String routingkey;

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
    
	/**
	 * @Description: 声明队列
	 * @author: afan
	 */
   @Bean(name = "QUEUE_CMS_POSTPAGE")
	public Queue QUEUE_CMS_POSTPAGE(){
		  return new Queue(queue_cms_postpage_name);

	}

	/**
	 * @Description:  绑定交换机和队列
	 * @author: afan
	 */
    @Bean
	public Binding BINDING_QUEUE_CMS_POSTPAGE(@Qualifier("QUEUE_CMS_POSTPAGE")Queue queue,
											  @Qualifier(EX_ROUTING_CMS_POSTPAGE) Exchange exchange){

		return BindingBuilder.bind(queue).to(exchange).with(routingkey).noargs();

	}
}
