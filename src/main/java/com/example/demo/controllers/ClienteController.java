package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Cliente cliente){
		int cli = service.insert(cliente);
		return cli != 0 ? new ResponseEntity<>("Cliente Criado", HttpStatus.OK) 
						: new ResponseEntity<>("Erro Cliente", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	public List<Cliente> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente findbById(@PathVariable Integer id) {
		return service.findbById(id);
	}

}
