package com.touzbi.checkers.board.path;

import java.util.List;

import com.touzbi.checkers.board.Token;
import com.touzbi.checkers.board.TokenColor;

public class PathUtils {

	public static boolean isTokenPathValid(List<Token> tokenPath,
			TokenColor tokenColor) {
		if (tokenPath.size() < 1) {
			return false;
		}

		Token lastToken = tokenPath.get(tokenPath.size() - 1);

		if (lastToken != null) {
			return false;
		}

		if (tokenPathContainsColor(tokenPath, tokenColor)
				|| tokenPathContainsAdjacentTokens(tokenPath)) {
			return false;
		}

		return true;
	}

	private static boolean tokenPathContainsColor(List<Token> tokenPath,
			TokenColor tokenColor) {

		for (Token token : tokenPath) {
			if (token != null && token.getTokenColor().equals(tokenColor)) {
				return true;
			}
		}

		return false;
	}

	private static boolean tokenPathContainsAdjacentTokens(List<Token> tokenPath) {
		if (tokenPath.size() < 2) {
			return false;
		}

		for (int i = 0; i < tokenPath.size() - 1; i++) {
			if (tokenPath.get(i) != null && tokenPath.get(i + 1) != null) {
				return true;
			}
		}

		return false;
	}
}
