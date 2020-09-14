package com.sgcpf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgcpf.domain.Cpf;

@Repository
public interface CpfRepository extends JpaRepository<Cpf, Integer>{
	
	@Transactional(readOnly=true)
	Cpf findByCpf(String Cpf);

}
