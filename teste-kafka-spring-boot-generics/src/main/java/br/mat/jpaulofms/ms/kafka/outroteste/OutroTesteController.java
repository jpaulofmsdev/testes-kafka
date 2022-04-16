package br.mat.jpaulofms.ms.kafka.outroteste;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mat.jpaulofms.ms.kafka.outroteste.model.CreateOutroTesteDTO;
import br.mat.jpaulofms.ms.kafka.outroteste.model.OutroTeste;
import br.mat.jpaulofms.ms.kafka.teste.TesteController;

@RestController
@RequestMapping("outro-teste")
public class OutroTesteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TesteController.class);

	private final OutroTesteService outroTesteService;

	public OutroTesteController(OutroTesteService outroTesteService) {
		this.outroTesteService = outroTesteService;
	}

	@GetMapping
	public List<OutroTeste> listOutroTeste() {
		LOGGER.info("listTeste");
		return outroTesteService.listOutroTeste();
	}

	@PostMapping
	public String addOutroTeste(@RequestBody CreateOutroTesteDTO createOutroTeste) {
		LOGGER.info("addOutroTeste: {}", createOutroTeste);
		String result = outroTesteService.createOutroTeste(createOutroTeste.toModel());
		return result;
	}

}
