package com.touzbi.checkers.board.path;

public class NoAvailablePathException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoAvailablePathException() {
		super("No path available");
	}
}
