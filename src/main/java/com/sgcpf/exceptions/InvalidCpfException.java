package com.sgcpf.exceptions;

public class InvalidCpfException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCpfException() {
		super("CPF inválido!");
	}
}
