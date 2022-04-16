package br.mat.jpaulofms.ms.kafka.outroteste;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.mat.jpaulofms.ms.kafka.config.TesteKafkaConfiguration;
import br.mat.jpaulofms.ms.kafka.outroteste.model.OutroTeste;

@Service
public class OutroTesteService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OutroTesteService.class);

	private final List<OutroTeste> outrosTestes = new ArrayList<>();
	private final KafkaTemplate<String, OutroTeste> kafkaTemplate;

	public OutroTesteService(KafkaTemplate<String, OutroTeste> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public List<OutroTeste> listOutroTeste() {
		LOGGER.info("listOutroTeste: {}");
		return outrosTestes;
	}

	public String createOutroTeste(OutroTeste outroTeste) {
		LOGGER.info("createOutroTeste: {}", outroTeste);
		outroTeste.setOutroId(UUID.randomUUID().toString());
		outroTeste.getMiniTestes().stream()
			.forEach(miniTeste -> miniTeste.setMiniTesteId(UUID.randomUUID().toString()));
		kafkaTemplate.send(TesteKafkaConfiguration.OUTRO_TESTE_TOPIC_NAME, outroTeste.getOutroId(), outroTeste);
		return outroTeste.getOutroId();
	}

	public void addOutroTeste(OutroTeste outroTeste) {
		LOGGER.info("addOutroTeste: {}", outroTeste);
		outrosTestes.add(outroTeste);
	}
}
