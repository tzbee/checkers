package com.touzbi.checkers.boardcontroller;

import com.touzbi.checkers.board.Board;

public abstract class AbstractBoardController implements BoardController {
	protected Board board;

	public AbstractBoardController(Board board) {
		this.board = board;
	}

	@Override
	public Board getBoardCopy() {
		return this.board.getCopy();
	}

	protected abstract void checkMove(Move move) throws ControllerException;
}
