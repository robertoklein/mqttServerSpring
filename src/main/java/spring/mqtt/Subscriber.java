package spring.mqtt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import spring.models.DataMqtt;
import spring.service.DataMqttService;

@Configuration
public class Subscriber implements MqttCallback{

	@Autowired
	DataMqttService mqttService;
	
	//private static final int  QOS = 1;
	
		public Subscriber() throws MqttException{
		
			MqttClient client = Connection.getClient();
	        MqttConnectOptions conOpt = Connection.getOptions();

	        client.setCallback(this);
	        client.connect(conOpt);

	        //lista de topics ouvidos
	        String[] list = Connection.TOPICS;
	        client.subscribe(list);
		}
		
		@Override
		public void connectionLost(Throwable cause) {
			 System.out.println("Connection lost because: " + cause);
		        System.exit(1);
		}

		@Override
		public void messageArrived(String topic, MqttMessage message) throws Exception {
			
			String result = new String(message.getPayload());
			String topicResult = topic;
			
			System.out.println("a data was insert into the topic: " + topicResult);
			System.out.println("the msg is: " + result);
	
			
			
		

			DataMqtt data = new DataMqtt();
			data.setMessage(result);
			data.setTopic(topicResult);
			
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter
			  .ofLocalizedDateTime(FormatStyle.SHORT)
			  .withLocale(new Locale("pt", "br"));
			agora.format(formatador); //08/04/14 10:02
			
			data.setData(agora);
			
			mqttService.insereData(data);
		}
		

		@Override
		public void deliveryComplete(IMqttDeliveryToken token) {
			System.out.println("entrou no delivery complete");
		}	
}
