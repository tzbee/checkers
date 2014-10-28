package com.touzbi.checkers.boardcontroller;

import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.TokenColor;

public interface BoardController {
	Board getBoardCopy();

	void play(TokenColor tokenColor, Move move) throws ControllerException;
}
