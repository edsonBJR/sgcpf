package com.sgcpf.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgcpf.domain.Cpf;

@RestController
@RequestMapping(value="/cpf")
public class CpfResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Cpf> listar() {
		

		Cpf cpf1 = new Cpf("06889060601", "20200912");
		Cpf cpf2 = new Cpf("04828212647", "20200813");
		
		List<Cpf> lista = new ArrayList<>();
		lista.add(cpf1);
		lista.add(cpf2);
		
		return lista;
	}
}
