package com.sgcpf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcpf.domain.Cpf;
import com.sgcpf.repositories.CpfRepository;
import com.sgcpf.services.exceptions.ObjectNotFoundException;

@Service
public class CpfService {

	@Autowired
	private CpfRepository cpfRepository;
	
	public Cpf cadastrar() {
	
		return null;
	}
	
	public List<Cpf> listarTodos() {
		return cpfRepository.findAll();
	}
	
	public Cpf findByCpf(String cpf) {
	
		Cpf obj = cpfRepository.findByCpf(cpf);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpf);
		}
		return obj;
	}
	
	public Cpf deletar(String cpf) {
		
		return null;
	}

}
