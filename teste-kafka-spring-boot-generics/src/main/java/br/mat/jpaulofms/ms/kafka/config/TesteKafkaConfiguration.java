package br.mat.jpaulofms.ms.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class TesteKafkaConfiguration {
	
	public static final String TESTE_TOPIC_NAME = "teste-topico-generico";
	public static final String OUTRO_TESTE_TOPIC_NAME = "outro-teste-topico-generico";
	
	@Bean
    public NewTopic testeTopico() {
        return TopicBuilder.name(TESTE_TOPIC_NAME)
                .partitions(1)
                .replicas(1)
                .build();
    }
	
	@Bean
    public NewTopic outroTesteTopico() {
        return TopicBuilder.name(OUTRO_TESTE_TOPIC_NAME)
                .partitions(1)
                .replicas(1)
                .build();
    }
	
	@Bean
    public JsonMessageConverter jsonMessageConverter() {
        return new ByteArrayJsonMessageConverter();
    }
	
}
