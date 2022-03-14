package com.springboot.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.constant.ApplicationConstant;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/{message}")
	public String sendMessage(@PathVariable("message") String message) {
		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return "message successfully sent";

	}

	@GetMapping("/showmessages")
	public String showMessage(String showmessages) {
		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, showmessages);

		} catch (Exception e) {

		}
		return showmessages;

	}

}
