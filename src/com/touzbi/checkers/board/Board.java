package com.touzbi.checkers.board;

import java.util.Collection;

import com.touzbi.checkers.NoTokenException;
import com.touzbi.checkers.Position;
import com.touzbi.checkers.PositionOutOfBoundsException;

public interface Board extends Copiable<Board> {
	int getNbOfRows();

	int getNbOfColumns();

	void moveToken(Token token, Position position) throws NoTokenException,
			PositionOutOfBoundsException;

	public Collection<Token> getAllTokens();

	Token getTokenByPosition(Position position) throws NoTokenException,
			PositionOutOfBoundsException;

	Collection<Token> getTokensByColor(TokenColor tokenColor);

	Collection<Position> getEmptyPositions();

	boolean isPositionOutOfBounds(Position position);

	boolean isPositionFree(Position position)
			throws PositionOutOfBoundsException;
}
