package com.touzbi.checkers.test;

import org.junit.Test;

import com.touzbi.checkers.board.BoardFactory;
import com.touzbi.checkers.boardcontroller.BasicBoardController;
import com.touzbi.checkers.boardcontroller.BoardController;
import com.touzbi.checkers.gamecontroller.BasicGameController;
import com.touzbi.checkers.gamecontroller.GameController;

public class GameTest {
	private static final BoardController BOARD_CONTROLLER = new BasicBoardController(
			BoardFactory.createStandardBoard());
	private static final GameController GAME_CONTROLLER = new BasicGameController(
			BOARD_CONTROLLER);

	@Test
	public void test() {
		System.out.println(GAME_CONTROLLER);

		GAME_CONTROLLER.start();
	}
}
