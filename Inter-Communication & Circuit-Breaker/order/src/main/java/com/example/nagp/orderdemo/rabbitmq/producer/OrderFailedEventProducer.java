package com.example.nagp.orderdemo.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nagp.orderdemo.model.OrderFailedEventProductMessage;



@Component
public class OrderFailedEventProducer {

	/*@Autowired
	private AmqpTemplate rabbitmqTemplate;

	@Autowired
	private MessageConverter messageConvertor;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderFailedEventProducer.class);

	public void produceEventProductUpdate(final OrderFailedEventProductMessage message) {
		LOGGER.info("Order failed producing event for product :{}", message);
		rabbitmqTemplate.convertAndSend("nes_product_exchange", "product_update",
				messageConvertor.toMessage(message, new MessageProperties()));

	}*/

}
