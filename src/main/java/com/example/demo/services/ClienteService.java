package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepositoryDAO;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositoryDAO repository;
	
	public int insert(Cliente cliente) {
		return repository.insert(cliente);
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findbById(Integer id) {
		return repository.findbById(id);
	}

}
