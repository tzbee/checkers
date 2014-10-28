package com.touzbi.checkers.player.movemaker;

import java.util.Scanner;

import com.touzbi.checkers.Position;
import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.boardcontroller.Move;

public class ConsoleMoveMaker implements MoveMaker {

	@Override
	public Move selectNextMove(TokenColor tokenColor, Board boardCopy) {
		Move move = new Move();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int selectedRow = -1, selectedColumn = -1;

		selectedRow = scanner.nextInt();
		selectedColumn = scanner.nextInt();

		move.setStartPosition(new Position(selectedRow, selectedColumn));

		int rowIndex = -1, columnIndex = -1;

		rowIndex = scanner.nextInt();
		columnIndex = scanner.nextInt();

		move.setEndPosition(new Position(rowIndex, columnIndex));

		return move;
	}

	@Override
	public String toString() {
		return "Console move maker";
	}
}
