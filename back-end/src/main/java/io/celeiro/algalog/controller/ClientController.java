package io.celeiro.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.celeiro.algalog.domain.model.Client;
import io.celeiro.algalog.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
	
	//@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<Client> listAllClients() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> listClient(@PathVariable Long id) {
		
		//Optional
		return clientRepository.findById(id)
				//.map(client -> ResponseEntity.ok(client))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client addClient(@Valid @RequestBody Client client) {
		
		return clientRepository.save(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client client) {
		
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		client = clientRepository.save(client);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		
		if(!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clientRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}