package com.touzbi.checkers.player;

import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.gamecontroller.GameController;

public abstract class AbstractPlayer implements Player {
	private final TokenColor tokenColor;
	private GameController gameController;

	public AbstractPlayer(GameController gameController, TokenColor tokenColor) {
		this.gameController = gameController;
		this.tokenColor = tokenColor;
	}

	@Override
	public TokenColor getTokenColor() {
		return tokenColor;
	}

	public GameController getGameController() {
		return gameController;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractPlayer)) {
			return false;
		}

		AbstractPlayer player = (AbstractPlayer) obj;

		return getTokenColor().equals(player.getTokenColor());
	}
}
