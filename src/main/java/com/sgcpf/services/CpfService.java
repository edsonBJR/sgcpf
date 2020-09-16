package com.sgcpf.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcpf.domain.Cpf;
import com.sgcpf.dto.CpfDTO;
import com.sgcpf.repositories.CpfRepository;

@Service
public class CpfService {
	
	@Autowired
	private CpfRepository cpfRepository;
	
	public Cpf cadastrar(Cpf obj) {
		obj.setId(null);
		obj.setCreatedAt(new Date());
		obj = cpfRepository.save(obj);
		return obj;
	}
	
	public Cpf fromDTO(CpfDTO objDto) {
		return new Cpf(objDto.getCpf(), objDto.getCreatedAt());
	}
	
	public List<Cpf> buscarTodos() {
		return cpfRepository.findAll();
	}
	
	public Cpf buscarCpf(String cpf){
		Cpf	obj = cpfRepository.findByCpf(cpf);	
		return obj;			
	}
	
	public void deletar(String cpf) {
		Cpf obj = buscarCpf(cpf);
		cpfRepository.delete(obj);
	}

}
