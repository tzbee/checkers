package com.touzbi.checkers.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.touzbi.checkers.NoTokenException;
import com.touzbi.checkers.Position;
import com.touzbi.checkers.PositionOutOfBoundsException;
import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.BoardFactory;
import com.touzbi.checkers.board.Token;

public class TokenTest {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Board BOARD = BoardFactory.createStandardBoard();

	@Test
	public void tokenValidMovesTest() {
		System.out.println(BOARD);

		Token token = null;

		try {
			token = BOARD.getTokenByPosition(new Position(0, 4));
		} catch (NoTokenException | PositionOutOfBoundsException e) {
			LOGGER.error(e.getMessage());
		}

		System.out.println("Valid moves for " + token + ": "
				+ token.getValidMoves());
	}
}
