package com.touzbi.checkers.boardcontroller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.touzbi.checkers.NoTokenException;
import com.touzbi.checkers.Position;
import com.touzbi.checkers.PositionOutOfBoundsException;
import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.Token;
import com.touzbi.checkers.board.TokenColor;

public class BasicBoardController extends AbstractBoardController {
	private static final Logger LOGGER = LogManager.getLogger();

	public BasicBoardController(Board board) {
		super(board);
	}

	@Override
	protected void checkMove(Move move) throws ControllerException {
		try {
			Token token = this.board
					.getTokenByPosition(move.getStartPosition());

			Position endPosition = move.getEndPosition();

			if (!token.isValidMove(endPosition)) {
				throw new ControllerException(
						"This token is not allowed to move to " + endPosition);
			}

		} catch (NoTokenException | PositionOutOfBoundsException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@Override
	public void play(TokenColor tokenColor, Move move)
			throws ControllerException {
		LOGGER.info("Playing '{}'", move);

		checkMove(move);

		try {
			Token token = this.board
					.getTokenByPosition(move.getStartPosition());

			if (!token.getTokenColor().equals(tokenColor)) {
				throw new ControllerException(
						"Player not allowed to play this color");
			}

			this.board.moveToken(token, move.getEndPosition());
		} catch (NoTokenException | PositionOutOfBoundsException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return this.board.toString();
	}
}
