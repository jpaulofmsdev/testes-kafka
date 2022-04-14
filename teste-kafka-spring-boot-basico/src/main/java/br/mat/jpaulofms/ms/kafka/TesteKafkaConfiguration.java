package br.mat.jpaulofms.ms.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class TesteKafkaConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(TesteKafkaConfiguration.class);
	
	@Bean
    public NewTopic topic() {
        return TopicBuilder.name("teste-topico")
                .partitions(5)
                .replicas(3)
                .build();
    }
	
	/*
	 * kafka-console-producer --topic teste-topico --bootstrap-server localhost:9092
	 */
	@KafkaListener(groupId = "teste-grupo-1", topics = "teste-topico")
	public void listen(String payload) {
		LOGGER.info("Payload: {}", payload);
    }

	/*
	 * kafka-console-producer --topic teste-topico --bootstrap-server localhost:9092 --property "parse.key=true" --property "key.separator=:"
	 */
    @KafkaListener(groupId = "teste-grupo-2", topics = "teste-topico")
    public void listen(@Payload String payload,
            @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) Integer key,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
    	LOGGER.info("Payload: {}, key: {}, partition: {}, topic: {}, timestamp: {}", payload, key, partition, topic, ts);
    }
    
    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            template.send("teste-topico", "teste producer");
        };
    }
	
}
