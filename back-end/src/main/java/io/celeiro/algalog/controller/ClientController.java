package io.celeiro.algalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.celeiro.algalog.domain.model.Client;
import io.celeiro.algalog.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {
	
	//@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> listar() {
		return clientRepository.findAll();
	}
}