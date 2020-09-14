package com.sgcpf.dto;

import java.util.Date;

import com.sgcpf.domain.Cpf;

public class CpfDTO {
	
	private String cpf;
	private Date createdAt;
	
	public CpfDTO() {
		
	}
	
	public CpfDTO(Cpf obj) {
		cpf = obj.getCpf();
		createdAt = obj.getCreatedAt();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
