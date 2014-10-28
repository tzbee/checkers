package com.touzbi.checkers.gamecontroller;

import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.boardcontroller.Move;
import com.touzbi.checkers.player.Player;

public interface GameController {
	void play(Player player, Move move) throws GameException;

	void start();

	Board getBoardCopy();
}
