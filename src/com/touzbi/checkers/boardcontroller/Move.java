package com.touzbi.checkers.boardcontroller;

import java.util.ArrayList;
import java.util.List;

import com.touzbi.checkers.NoTokenException;
import com.touzbi.checkers.Position;
import com.touzbi.checkers.PositionOutOfBoundsException;
import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.Token;
import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.board.path.NoAvailablePathException;

public class Move {
	private TokenColor startTokenColor;
	private Position startPosition;
	private Position endPosition;

	private Board board;
	private List<Token> tokenPath;

	public Move() {
	}

	public Move(Board board, Position startPosition, Position endPosition)
			throws NoAvailablePathException {
		this.board = board;
		this.startPosition = startPosition;
		this.endPosition = endPosition;

		try {
			this.startTokenColor = board.getTokenByPosition(startPosition)
					.getTokenColor();
		} catch (NoTokenException | PositionOutOfBoundsException e) {
			throw new NoAvailablePathException();
		}

		buildTokenPath();
	}

	public Move(Board board, int row1, int column1, int row2, int column2)
			throws NoAvailablePathException {
		this(board, new Position(row1, column1), new Position(row2, column2));
	}

	public Move(Position position, Position translate) {
		// TODO Move constructor (Position position, Position translate) 
	}

	public Position getStartPosition() {
		return this.startPosition;
	}

	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	public Position getEndPosition() {
		return this.endPosition;
	}

	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}

	public TokenColor getTokenColor() {
		return startTokenColor;
	}

	private List<Position> getPath() throws NoAvailablePathException {
		List<Position> path = new ArrayList<Position>();

		Position position1 = this.startPosition.getCopy();
		int rowTranslation = 0, columnTranslation = 0;

		if (Math.abs(this.startPosition.getRow() - this.endPosition.getRow()) != Math
				.abs(this.startPosition.getColumn()
						- this.endPosition.getColumn())) {
			throw new NoAvailablePathException();
		}

		while (!position1.equals(this.endPosition)) {
			if (position1.getRow() > this.endPosition.getRow()) {
				rowTranslation = -1;
			} else {
				rowTranslation = 1;
			}
			if (position1.getColumn() > this.endPosition.getColumn()) {
				columnTranslation = -1;
			} else {
				columnTranslation = 1;
			}

			path.add(position1.translate(rowTranslation, columnTranslation));
		}

		return path;
	}

	private void buildTokenPath() throws NoAvailablePathException {
		this.tokenPath = new ArrayList<Token>();

		for (Position position : getPath()) {
			try {
				this.tokenPath.add(this.board.getTokenByPosition(position));
			} catch (NoTokenException | PositionOutOfBoundsException e) {
				this.tokenPath.add(null);
			}
		}
	}

	public boolean containsSameColor() {
		for (Token token : this.tokenPath) {
			if (token != null
					&& token.getTokenColor().equals(this.startTokenColor)) {
				return true;
			}
		}

		return false;
	}

	public boolean isLastPositionEmpty() {
		try {
			return this.board.isPositionFree(this.endPosition);
		} catch (PositionOutOfBoundsException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Move [" + getStartPosition() + ", " + getEndPosition() + "]";
	}

	public Move isValid() {
		// TODO Move isValid
		return null;
	}
}
