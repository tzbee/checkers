package com.touzbi.checkers.gamecontroller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.boardcontroller.BoardController;
import com.touzbi.checkers.boardcontroller.ControllerException;
import com.touzbi.checkers.boardcontroller.Move;
import com.touzbi.checkers.player.AbstractPlayer;
import com.touzbi.checkers.player.DirectPlayer;
import com.touzbi.checkers.player.Player;
import com.touzbi.checkers.player.movemaker.AIMoveMaker;
import com.touzbi.checkers.player.movemaker.ConsoleMoveMaker;

public class BasicGameController implements GameController {
	private static final Logger LOGGER = LogManager.getLogger();

	private final AbstractPlayer[] players = {
			new DirectPlayer(this, TokenColor.BLACK, new ConsoleMoveMaker()),
			new DirectPlayer(this, TokenColor.WHITE, new AIMoveMaker()) };

	private int currentPlayerIndex = 0;

	private BoardController boardController;

	public BasicGameController(BoardController boardController) {
		this.boardController = boardController;
	}

	public AbstractPlayer getCurrentPlayer() {
		return this.players[this.currentPlayerIndex];
	}

	private void nextPlayer() {
		this.currentPlayerIndex = this.currentPlayerIndex >= this.players.length - 1 ? 0
				: this.currentPlayerIndex + 1;
	}

	@Override
	public void play(Player player, Move move) throws GameException {

		if (!player.equals(getCurrentPlayer())) {
			throw new GameException("Player not allowed to play");
		}

		try {
			this.boardController.play(player.getTokenColor(), move);
			LOGGER.info("\n" + this);

			nextPlayer();
			getCurrentPlayer().startTurn();

		} catch (ControllerException e) {
			throw new GameException(e.getMessage());
		}
	}

	@Override
	public void start() {
		getCurrentPlayer().startTurn();
	}

	@Override
	public String toString() {
		return this.boardController.toString();
	}

	@Override
	public Board getBoardCopy() {
		return this.boardController.getBoardCopy();
	}
}
