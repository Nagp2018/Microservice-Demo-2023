package com.example.nagp.orderdemo.kafka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderPlacedEventProcessor {
	private static final Logger logger = LoggerFactory.getLogger(OrderPlacedEventProcessor.class);

	private static final String TOPIC = "ProductNotAvaialbleEvent";

	/*@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaProperties kafkaProperties;*/

	public void sendMessage(String statusChange){

		logger.info(String.format("$$ -> Producing message --> %s",statusChange));

		//this.kafkaTemplate.send(TOPIC,statusChange);
	

	}

}