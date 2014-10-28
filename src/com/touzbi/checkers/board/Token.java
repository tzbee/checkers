package com.touzbi.checkers.board;

import java.util.ArrayList;
import java.util.Collection;

import com.touzbi.checkers.Position;
import com.touzbi.checkers.board.path.NoAvailablePathException;
import com.touzbi.checkers.boardcontroller.Move;

public class Token {
	private static final Position[] TRANSLATIONS = { new Position(1, 1),
			new Position(-1, 1), new Position(1, -1), new Position(-1, -1) };

	private final TokenColor tokenColor;
	private Position position;

	private Board board;
	private Collection<Position> validMoves = null;

	private Token(Board board, TokenColor tokenColor, Position position) {
		this.board = board;
		this.tokenColor = tokenColor;
		this.position = position;
		updateValidMoves();
	}

	public Token(Board board, TokenColor tokenColor) {
		this(board, tokenColor, new Position());
	}

	public Token(Token token, Board board) {
		this(board, token.getTokenColor(), token.getPosition());
	}

	public TokenColor getTokenColor() {
		return tokenColor;
	}

	public int getRow() {
		return this.position.getRow();
	}

	public int getColumn() {
		return this.position.getColumn();
	}

	public Position getPosition() {
		return position.getCopy();
	}

	public Board getBoard() {
		return board;
	}

	protected void updateValidMoves() {
		if (this.validMoves == null) {
			this.validMoves = new ArrayList<Position>();
		}

		Position endPosition = null;
		Move move = null;

		for (Position translation : TRANSLATIONS) {
			endPosition = getPosition().translate(translation);
			try {
				move = new Move(this.board, getPosition(), endPosition);

				if (move.isLastPositionEmpty() && !move.containsSameColor()) {
					this.validMoves.add(endPosition);
				}

			} catch (NoAvailablePathException e) {
			}
		}
	}

	public Collection<Position> getValidMoves() {
		return new ArrayList<Position>(this.validMoves);
	}

	public final boolean isValidMove(Position position) {
		return this.validMoves.contains(position);
	}

	@Override
	public String toString() {
		return getTokenColor() + " " + getPosition();
	}
}
