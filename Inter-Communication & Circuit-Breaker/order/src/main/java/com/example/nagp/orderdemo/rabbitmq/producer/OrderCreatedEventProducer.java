package com.example.nagp.orderdemo.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nagp.orderdemo.model.OrderCreatedEventMessage;



@Component
public class OrderCreatedEventProducer {

	/*@Autowired
	private AmqpTemplate rabbitmqTemplate;

	@Autowired
	private MessageConverter messageConvertor;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderFailedEventProducer.class);

	public void produceEventOrderCreatedDelivery(final OrderCreatedEventMessage message) {
		LOGGER.info("Order created producing event for delivery :{}", message);
		rabbitmqTemplate.convertAndSend("tracking", "create_order_shipping_event",
				messageConvertor.toMessage(message, new MessageProperties()));

	}*/

}
