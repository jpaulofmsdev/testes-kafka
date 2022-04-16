package br.mat.jpaulofms.ms.kafka.teste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.mat.jpaulofms.ms.kafka.config.TesteKafkaConfiguration;
import br.mat.jpaulofms.ms.kafka.teste.model.Teste;
import br.mat.jpaulofms.ms.kafka.teste.model.TesteSemDataHora;
import br.mat.jpaulofms.ms.kafka.teste.model.TesteSemNome;

@Component
public class TesteKafkaListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TesteKafkaListener.class);
	
	private final TesteService testeService;
	
	public TesteKafkaListener(TesteService testeService) {
		this.testeService = testeService;
	}

	@KafkaListener(groupId = "teste-topico-generico-grupo-1", topics = TesteKafkaConfiguration.TESTE_TOPIC_NAME)
	public void addTeste(Teste payload) {
		LOGGER.info("addTeste: {}", payload);
		testeService.addTeste(payload);
	}
	
	@KafkaListener(groupId = "teste-topico-generico-grupo-2", topics = TesteKafkaConfiguration.TESTE_TOPIC_NAME)
	public void addTesteSemData(TesteSemDataHora testeSemDataHora) {
		LOGGER.info("addTesteSemData: {}. Apenas para mostrar que pode-se usar apenas as informaçõe que forem necessárias do JSON consumido", testeSemDataHora);
	}
	
	@KafkaListener(groupId = "teste-topico-generico-grupo-3", topics = TesteKafkaConfiguration.TESTE_TOPIC_NAME)
	public void addTesteSemNome(TesteSemNome testeSemNome) {
		LOGGER.info("addTesteSemNome: {}. Apenas para mostrar que pode-se usar apenas as informaçõe que forem necessárias do JSON consumido", testeSemNome);
	}
	
}
