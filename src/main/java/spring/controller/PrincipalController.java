package spring.controller;

import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import spring.models.DataMqtt;
import spring.mqtt.Publisher;
import spring.service.PrincipalService;

@RestController
public class PrincipalController {

	@Autowired
	PrincipalService principalService;
	
	@RequestMapping(value="listaDados")
	public List<DataMqtt> listaDados(){
		List<DataMqtt> lista = principalService.listarDados();			
		return lista;
	}
	
	@RequestMapping(value="ligaLed")
	public void ligaLed() throws MqttException {
		Publisher pub = new Publisher("led/liga", "liga");
	}
	
	@RequestMapping(value="desligaLed")
	public void desligaLed() throws MqttException {
		Publisher pub = new Publisher("led/desliga", "desliga");
	}
	
	
}
