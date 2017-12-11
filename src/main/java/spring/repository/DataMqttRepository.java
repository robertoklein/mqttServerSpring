package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.models.DataMqtt;



@Repository
public interface DataMqttRepository extends JpaRepository<DataMqtt,Integer>{


	
}
