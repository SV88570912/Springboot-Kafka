package com.springboot.kafka.consumers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import com.springboot.kafka.constant.ApplicationConstant;

@Component
public class KafkaConsumer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(groupId = ApplicationConstant.GROUP_ID_STRING,topics = ApplicationConstant.TOPIC_NAME,
			containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
	public void receivedMessaged(String message) {
		logger.info("messaged received using kafka Listener" + message);
		
		
	}

}
