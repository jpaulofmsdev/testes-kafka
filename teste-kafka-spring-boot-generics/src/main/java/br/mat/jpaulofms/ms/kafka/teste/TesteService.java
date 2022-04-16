package br.mat.jpaulofms.ms.kafka.teste;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.mat.jpaulofms.ms.kafka.config.TesteKafkaConfiguration;
import br.mat.jpaulofms.ms.kafka.teste.model.Teste;

@Service
public class TesteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TesteService.class);
	
	private final List<Teste> testes = new ArrayList<>();
	private final KafkaTemplate<String, Teste> kafkaTemplate;

	public TesteService(KafkaTemplate<String, Teste> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public List<Teste> listTeste() {
		LOGGER.info("listTeste: {}");
		return testes;
	}

	public void createTeste(Teste teste) {
		LOGGER.info("createTeste: {}", teste);
		kafkaTemplate.send(TesteKafkaConfiguration.TESTE_TOPIC_NAME, teste.getId(), teste);
	}

	public void addTeste(Teste teste) {
		LOGGER.info("addTeste: {}", teste);
		testes.add(teste);
	}
	
}
