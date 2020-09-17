package com.sgcpf.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sgcpf.config.validation.ValidaCPF;
import com.sgcpf.domain.Cpf;
import com.sgcpf.domain.Cpfs;
import com.sgcpf.dto.CpfDTO;
import com.sgcpf.exceptions.InvalidCpfException;
import com.sgcpf.exceptions.NotFoundCpfException;
import com.sgcpf.services.CpfService;

@RestController
@RequestMapping(value="/cpf")
public class CpfResource {

	@Autowired
	private CpfService cpfService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Cpfs> buscarTodos() {
	
		Cpfs resposta = new Cpfs();
		ArrayList<Cpf> list = new ArrayList<>();
		cpfService.buscarTodos().forEach(e -> list.add(e));
		resposta.setCpfList(list);
		return ResponseEntity.ok().body(resposta);
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<Cpf> buscar(@PathVariable String cpf) {
		
		// Validando CPF - Classe ValidaCPF.java
		if(ValidaCPF.isCPF(cpf) == false ) {
			throw new InvalidCpfException();
		}
		
		List<Cpf> list = cpfService.buscarTodos();
		
		for(Cpf item : list) {
			if(item.getCpf().equals(cpf)) {
				return ResponseEntity.ok().body(item);			
			}
		}
		throw new NotFoundCpfException();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid CpfDTO objDto) {
		
		// Validando CPF - Classe ValidaCPF.java
		if(ValidaCPF.isCPF(objDto.getCpf()) == false ) {
			throw new InvalidCpfException();
		}
		
		// Checando se o CPF já está cadastrado
		List<Cpf> list = cpfService.buscarTodos();
		for(Cpf cpf : list) {
			if(cpf.getCpf().equals(objDto.getCpf())) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		Cpf obj = cpfService.fromDTO(objDto);
		obj = cpfService.cadastrar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable String cpf) {
		
		// Validando CPF - Classe ValidaCPF.java
		if(ValidaCPF.isCPF(cpf) == false ) {
			throw new InvalidCpfException();
		}
		
		Cpf obj = cpfService.buscarCpf(cpf);
		
		if(obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		cpfService.deletar(cpf);
		return ResponseEntity.noContent().build();
		
	}
}
