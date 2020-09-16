package com.sgcpf.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sgcpf.domain.Cpf;

public class CpfDTO {
	
	@NotNull @NotEmpty
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
