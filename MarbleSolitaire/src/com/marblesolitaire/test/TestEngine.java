package com.marblesolitaire.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marblesolitaire.engine.BFSFrontier;
import com.marblesolitaire.engine.DFSFrontier;
import com.marblesolitaire.engine.State;
import com.marblesolitaire.main.AdjacentAStarFrontier;
import com.marblesolitaire.main.MarbleSolitaireEngine;
import com.marblesolitaire.main.MarbleSolitaireState;
import com.marblesolitaire.main.ModifiedAdjacentAStarFrontier;

public class TestEngine {

	private static int DEFAULT_BOARD_SIZE = 7;

	@Test
	public void testCreateInitiateState() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireState initialState = new MarbleSolitaireEngine(new DFSFrontier<>()).createInitialState(MarbleSolitaireEngine.IO_DEFAULT_TXT);
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
	public void testToString() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireState initialState = new MarbleSolitaireEngine(new DFSFrontier<>()).createInitialState("./io/test/testBoard.txt");
		assertEquals("X O X \n  X O \nO   O \n", initialState.toString());
	}

	@Test
	public void testDFSRun() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new DFSFrontier<>());
		engine.setFilePath("./io/test/small.txt");
		runAndPrint(engine);
	}

	@Test
	public void testBFSRun() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new BFSFrontier<>());
		engine.setFilePath("./io/test/small.txt");
		runAndPrint(engine);
	}

	@Test
	public void testAdjacentAStarRun1() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new AdjacentAStarFrontier());
		engine.setFilePath("./io/test/adjacent1.txt");
		runAndPrint(engine);
	}

	@Test
	public void testAdjacentAStarRun2() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new AdjacentAStarFrontier());
		engine.setFilePath("./io/test/small.txt");
		runAndPrint(engine);
	}

	@Test
	public void testModifiedAdjacentAStarRun1() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new ModifiedAdjacentAStarFrontier());
		engine.setFilePath("./io/test/small.txt");
		runAndPrint(engine);
	}

	private void runAndPrint(MarbleSolitaireEngine engine) {
		engine.initiate();
		State state = engine.run();
		int finalAnswerNodes = 0;
		do {
			finalAnswerNodes++;
			System.out.println(String.format("%-3s------", finalAnswerNodes));
			System.out.println(state);
			System.out.println("Path:" + state.getPath());
			state = state.getPrevious();
		} while (state.getPrevious() != null);
		System.out.println(String.format("%-3s------", finalAnswerNodes));
		System.out.println(state);
		System.out.println("Path:" + state.getPath());
		System.out.println("Total visited nodes:" + engine.getVisitedNodes());
	}
}
