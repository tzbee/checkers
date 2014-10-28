package com.touzbi.checkers;

import com.touzbi.checkers.board.Copiable;

public class Position implements Copiable<Position> {
	private final int row;
	private final int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Position() {
		this(0, 0);
	}

	public Position(Position position) {
		this(position.getRow(), position.getColumn());
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Position translate(Position position) {
		return translate(position.getRow(), position.getColumn());
	}

	public Position translate(int row, int column) {
		return new Position(getRow() + row, getColumn() + column);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position)) {
			return false;
		}

		Position position = (Position) obj;

		return position.getRow() == getRow()
				&& position.getColumn() == getColumn();
	}

	@Override
	public Position getCopy() {
		return new Position(getRow(), getColumn());
	}

	@Override
	public String toString() {
		return "(" + getRow() + ", " + getColumn() + ")";
	}
}
