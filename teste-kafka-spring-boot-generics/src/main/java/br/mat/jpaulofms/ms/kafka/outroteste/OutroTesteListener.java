package br.mat.jpaulofms.ms.kafka.outroteste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.mat.jpaulofms.ms.kafka.config.TesteKafkaConfiguration;
import br.mat.jpaulofms.ms.kafka.outroteste.model.OutroTeste;

@Component
public class OutroTesteListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(OutroTesteListener.class);
	
	private final OutroTesteService outroTesteService;
	
	public OutroTesteListener(OutroTesteService outroTesteService) {
		this.outroTesteService = outroTesteService;
	}

	@KafkaListener(groupId = "outro-teste-topico-generico-grupo-1", topics = TesteKafkaConfiguration.OUTRO_TESTE_TOPIC_NAME)
	public void addTeste(OutroTeste payload) {
		LOGGER.info("addTeste: {}", payload);
		outroTesteService.addOutroTeste(payload);
	}
	
}
