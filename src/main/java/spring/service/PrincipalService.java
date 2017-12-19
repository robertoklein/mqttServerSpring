package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.models.DataMqtt;
import spring.repository.PrincipalRepository;

@Service
public class PrincipalService {

	@Autowired
	PrincipalRepository principalRepository;
	
	public List<DataMqtt> listarDados(){
		List<DataMqtt> lista = principalRepository.findAll();
		return lista;		
	}
	
}
