package com.touzbi.checkers.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.BoardFactory;
import com.touzbi.checkers.board.path.NoAvailablePathException;
import com.touzbi.checkers.boardcontroller.Move;

public class MoveTest {
	private static final Logger LOGGER = LogManager.getLogger();

	private static final Board BOARD = BoardFactory.createStandardBoard();

	@Test
	public void isValidTest() {
		try {
			System.out.println(BOARD);
			Move move = new Move(BOARD, 0, 4, 1, 3);
			System.out.println(move + " is valid: " + move.isValid());
		} catch (NoAvailablePathException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
