package com.touzbi.checkers.board;

import java.util.Collection;

import com.touzbi.checkers.NoTokenException;
import com.touzbi.checkers.Position;
import com.touzbi.checkers.PositionOutOfBoundsException;

public class StandardBoard implements Board{

	@Override
	public Board getCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbOfColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveToken(Token token, Position position)
			throws NoTokenException, PositionOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Token> getAllTokens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Token getTokenByPosition(Position position) throws NoTokenException,
			PositionOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Token> getTokensByColor(TokenColor tokenColor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Position> getEmptyPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPositionOutOfBounds(Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPositionFree(Position position)
			throws PositionOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	public void addTokenToPosition(Token token, Position position) throws PositionOutOfBoundsException{
		// TODO StandardBoard addTokenToPosition
		
	}

}
