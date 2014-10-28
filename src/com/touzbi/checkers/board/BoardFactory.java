package com.touzbi.checkers.board;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.touzbi.checkers.Position;
import com.touzbi.checkers.PositionOutOfBoundsException;

public class BoardFactory {
	private static final Logger LOGGER = LogManager.getLogger();

	public static Board createStandardBoard() {
		StandardBoard board = new StandardBoard();

		try {

			board.addTokenToPosition(new Token(board, TokenColor.BLACK),
					new Position(3, 4));
			board.addTokenToPosition(new Token(board, TokenColor.WHITE),
					new Position(0, 4));
			board.addTokenToPosition(new Token(board, TokenColor.BLACK),
					new Position(7, 4));
			board.addTokenToPosition(new Token(board, TokenColor.WHITE),
					new Position(1, 5));

		} catch (PositionOutOfBoundsException e) {
			LOGGER.info(e.getMessage());
			return board;
		}

		return board;
	}
}
