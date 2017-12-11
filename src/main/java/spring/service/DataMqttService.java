package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.models.DataMqtt;
import spring.repository.DataMqttRepository;

@Service
public class DataMqttService {

	@Autowired
	DataMqttRepository mqttRepository;
	
	public void insereData(DataMqtt data) {
		mqttRepository.save(data);
	}
	
}
