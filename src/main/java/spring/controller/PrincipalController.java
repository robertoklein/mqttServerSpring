package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import spring.models.DataMqtt;
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
}
