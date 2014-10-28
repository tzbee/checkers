package com.touzbi.checkers.board;

public class NoAvailablePathException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoAvailablePathException(String string) {
		super(string);
	}
}
