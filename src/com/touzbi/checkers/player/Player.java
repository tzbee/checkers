package com.touzbi.checkers.player;

import com.touzbi.checkers.board.TokenColor;

public interface Player {
	TokenColor getTokenColor();

	/**
	 * Callback message sent to the player announcing the beginning of the
	 * player's turn
	 */
	void startTurn();
}
