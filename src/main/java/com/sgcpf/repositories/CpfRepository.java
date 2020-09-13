package com.sgcpf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgcpf.domain.Cpf;

@Repository
public interface CpfRepository extends JpaRepository<Cpf, Integer>{

}
