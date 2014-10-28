package com.touzbi.checkers.player.movemaker;

import com.touzbi.checkers.board.Board;
import com.touzbi.checkers.board.TokenColor;
import com.touzbi.checkers.boardcontroller.Move;

public interface MoveMaker {
	Move selectNextMove(TokenColor tokenColor, Board boardCopy);
}
