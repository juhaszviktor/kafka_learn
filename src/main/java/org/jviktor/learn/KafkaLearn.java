package org.jviktor.learn;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaLearn {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		 
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,   StringSerializer.class.getName());
		
		KafkaProducer producer = new KafkaProducer<String,String>(props);
		ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("TutorialTopic", "key", "Hello from java");
		Future<RecordMetadata> future = producer.send(producerRecord);
		try {
			future.get();
		}
		catch (InterruptedException e) {
			System.out.println("Exception occured: " + e);
		}
		catch (ExecutionException e) {
			System.out.println("Exception occured: " + e);
		}
	    System.out.println("Hello World");
	}
}
