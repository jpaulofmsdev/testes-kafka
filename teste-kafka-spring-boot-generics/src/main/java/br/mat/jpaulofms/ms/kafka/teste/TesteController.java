package br.mat.jpaulofms.ms.kafka.teste;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mat.jpaulofms.ms.kafka.teste.model.Teste;

@RestController
@RequestMapping("teste")
public class TesteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TesteController.class);
	
	private final TesteService testeService;
	
	public TesteController(TesteService testeService) {
		this.testeService = testeService;
	}
	
	@GetMapping
	public List<Teste> listTeste() {
		LOGGER.info("listTeste");
		return testeService.listTeste();
	}
	
	@PostMapping
	public String addTeste(@RequestBody String nome) {
		LOGGER.info("addTeste: {}", nome);
		String id = UUID.randomUUID().toString();
		testeService.createTeste(new Teste(id, nome, LocalDateTime.now()));
		return id;
	}

}
