package com.sgcpf.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcpf.domain.Cpf;
import com.sgcpf.repositories.CpfRepository;

@Service
public class CpfService {

	@Autowired
	private CpfRepository cpfRepository;
	
	public Cpf buscar(Integer id) {
		Optional<Cpf> obj = cpfRepository.findById(id);
		return obj.orElse(null);
	}
}
