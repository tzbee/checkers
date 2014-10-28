package com.touzbi.checkers.board;

public enum TokenColor {
	BLACK, WHITE;

	public TokenColor getOpposite() {
		return this.equals(BLACK) ? WHITE : BLACK;
	}
}
