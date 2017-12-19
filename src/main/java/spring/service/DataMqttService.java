package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import spring.models.DataMqtt;
import spring.repository.DataMqttRepository;

@Service
public class DataMqttService {

	@Autowired
	DataMqttRepository mqttRepository;
	
	@Autowired
	private SimpMessagingTemplate template;

	public void insereData(DataMqtt data) {
		System.out.println("dentro do insereData");
		mqttRepository.save(data);
		this.template.convertAndSend("/topic/notify",data);	
	}
}
