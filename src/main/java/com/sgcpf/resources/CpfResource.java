package com.sgcpf.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgcpf.domain.Cpf;
import com.sgcpf.dto.CpfDTO;
import com.sgcpf.services.CpfService;

@RestController
@RequestMapping(value="/cpf")
public class CpfResource {

	@Autowired
	private CpfService cpfService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CpfDTO>> findAll() {
		List<Cpf> list = cpfService.listarTodos();
		List<CpfDTO> listDto = list.stream().map(obj -> new CpfDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<Cpf> find(@PathVariable String cpf) {
		Cpf obj = cpfService.findByCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
//		Cpf obj = cpfService.fromDTO(objDto);
//		obj = cpfService.cadastrar(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
	@RequestMapping(value="/{cpf}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String cpf) {
		cpfService.deletar(cpf);
		return ResponseEntity.noContent().build();
	}
}
