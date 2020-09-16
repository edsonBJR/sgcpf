package com.sgcpf.exceptions;

public class NotFoundCpfException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundCpfException() {
		super("CPF não encontrado!");
	}
}
