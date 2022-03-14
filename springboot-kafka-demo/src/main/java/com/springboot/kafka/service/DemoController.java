package com.springboot.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/demo")
public class DemoController {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final String topic = "test";

	@GetMapping("/publish/{message}")
	public String showMessage(@PathVariable("message") String message) {
		kafkaTemplate.send(topic, message);
		return message;

	}

}
