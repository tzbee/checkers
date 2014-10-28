package com.touzbi.checkers.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.touzbi.checkers.Position;

public class PositionTest {

	@Test
	public void test() {
		Collection<Position> positions = Arrays.asList(new Position(3, 4));

		System.out.println(positions.contains(new Position(6, 4)));
	}
}
