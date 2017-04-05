package com.marblesolitaire.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.marblesolitaire.engine.Board;

public class TestBoard {

	private static int DEFAULT_BOARD_SIZE = 7;

	@Test
	public void testInitiateBoard() {
		Board board = new Board();
		for (int x = 0; x < DEFAULT_BOARD_SIZE; x++) {
			for (int y = 0; y < DEFAULT_BOARD_SIZE; y++) {
				Boolean spot = board.getSpot(x, y);
				if ((x < 2 && y < 2) || (x < 2 && y > DEFAULT_BOARD_SIZE - 3) || (x > DEFAULT_BOARD_SIZE - 3 && y < 2)
						|| (x > DEFAULT_BOARD_SIZE - 3 && y > DEFAULT_BOARD_SIZE - 3)) {
					// Testing the boundaries
					assertNull(spot);
				} else if (x == 3 && y == 3) {
					// Testing the main spot
					assertFalse(spot);
				} else {
					// Testing the marbles
					assertTrue(spot);
				}
			}
		}
	}

	@Test
	public void testToString() {
		Board board = new Board("./io/test/testBoard.txt");
		assertEquals("XOX\n XO\nO O\n", board.toString());
	}
}
