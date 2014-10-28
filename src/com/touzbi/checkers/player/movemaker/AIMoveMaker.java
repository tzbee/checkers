package com.touzbi.checkers.player.movemaker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.touzbi.checkers.Position;
import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.Token;
import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.boardcontroller.Move;

public class AIMoveMaker implements MoveMaker {
	private static final long WAITING_TIME = 2000;

	@Override
	public Move selectNextMove(TokenColor tokenColor, Board boardCopy) {
		try {
			Thread.sleep(WAITING_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Collection<Token> tokens = boardCopy.getTokensByColor(tokenColor);

		List<Token> tokenList = new ArrayList<Token>(tokens);
		Token token = null;

		if (!tokenList.isEmpty()) {
			token = tokenList.get(0);

			return new Move(token.getPosition(), new Position(
					token.getPosition()).translate(1, 1));
		} else {
		}

		return new Move();
	}

	@Override
	public String toString() {
		return "AI";
	}
}
