package com.touzbi.checkers.player;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.gamecontroller.GameController;
import com.touzbi.checkers.gamecontroller.GameException;
import com.touzbi.checkers.player.movemaker.MoveMaker;

public class DirectPlayer extends AbstractPlayer {
	private static final Logger LOGGER = LogManager.getLogger();

	private MoveMaker moveMaker;

	public DirectPlayer(GameController gameController, TokenColor tokenColor,
			MoveMaker moveMaker) {
		super(gameController, tokenColor);
		this.moveMaker = moveMaker;
	}

	@Override
	public void startTurn() {
		GameController gameController = getGameController();

		try {
			gameController.play(this, this.moveMaker.selectNextMove(
					getTokenColor(), gameController.getBoardCopy()));
		} catch (GameException e) {
			LOGGER.error(e.getMessage());
			startTurn();
		}
	}
}
