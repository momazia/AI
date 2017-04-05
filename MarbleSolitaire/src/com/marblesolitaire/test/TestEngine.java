package com.marblesolitaire.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marblesolitaire.engine.Engine;
import com.marblesolitaire.engine.MarbleSolitaireState;

public class TestEngine {

	private static int DEFAULT_BOARD_SIZE = 7;

	@Test
	public void testCreateInitiateState() {
		MarbleSolitaireState initialState = new Engine().createInitialState(Engine.IO_DEFAULT_TXT);
		for (int x = 0; x < DEFAULT_BOARD_SIZE; x++) {
			for (int y = 0; y < DEFAULT_BOARD_SIZE; y++) {
				Boolean spot = initialState.getSpot(x, y);
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
		MarbleSolitaireState initialState = new Engine().createInitialState("./io/test/testBoard.txt");
		assertEquals("XOX\n XO\nO O\n", initialState.toString());
	}
}
