package com.sgcpf;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sgcpf.domain.Cpf;
import com.sgcpf.repositories.CpfRepository;

@SpringBootApplication
public class SgcpfApplication implements CommandLineRunner {

	@Autowired
	private CpfRepository cpfRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SgcpfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cpf cpf1 = new Cpf(null, "01234567890", "20200912");
		Cpf cpf2 = new Cpf(null, "01234567891", "20200911");
		
		cpfRepository.saveAll(Arrays.asList(cpf1, cpf2));
	}

}
