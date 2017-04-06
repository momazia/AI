package com.marblesolitaire.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.marblesolitaire.engine.DFSFrontier;
import com.marblesolitaire.engine.State;
import com.marblesolitaire.main.MarbleSolitaireEngine;
import com.marblesolitaire.main.MarbleSolitaireState;

public class TestMarbleSolitaireState {

	@Test
	public void testMoveUp() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new DFSFrontier<>());
		MarbleSolitaireState state = engine.createInitialState("./io/test/moveUp1.txt");
		assertNull(state.moveUp(0, 0));

		MarbleSolitaireState state1 = state.moveUp(3, 1);
		assertNotNull(state1);
		assertFalse(state1.getSpot(3, 1));
		assertFalse(state1.getSpot(3, 2));
		assertTrue(state1.getSpot(3, 3));

		assertNull(state.moveUp(3, 5));

		MarbleSolitaireState state2 = state.moveUp(3, 4);
		assertNotNull(state2);
		assertFalse(state2.getSpot(3, 4));
		assertFalse(state2.getSpot(3, 5));
		assertTrue(state2.getSpot(3, 6));

		assertNull(state.moveUp(0, 3));

		assertNull(state.moveUp(2, 5));
	}

	@Test
	public void testMoveDown() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new DFSFrontier<>());
		MarbleSolitaireState state = engine.createInitialState("./io/test/moveDown1.txt");
		assertNull(state.moveDown(0, 0));

		assertNull(state.moveDown(3, 1));

		MarbleSolitaireState state1 = state.moveDown(3, 5);
		assertNotNull(state1);
		assertFalse(state1.getSpot(3, 4));
		assertFalse(state1.getSpot(3, 5));
		assertTrue(state1.getSpot(3, 6));

		MarbleSolitaireState state2 = state.moveDown(3, 2);
		assertNotNull(state2);
		assertFalse(state2.getSpot(3, 2));
		assertFalse(state2.getSpot(3, 1));
		assertTrue(state2.getSpot(3, 0));

		assertNull(state.moveDown(0, 3));

		assertNull(state.moveDown(2, 1));
	}

	@Test
	public void testExpand1() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new DFSFrontier<>());
		MarbleSolitaireState state = engine.createInitialState("./io/test/expand1.txt");
		List<State> expand = state.expand();
		assertEquals(1, expand.size());
		// Left
		System.out.println("Left");
		System.out.println(expand.get(0));
	}

	@Test
	public void testExpand2() throws InstantiationException, IllegalAccessException {
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(new DFSFrontier<>());
		MarbleSolitaireState state = engine.createInitialState("./io/default.txt");
		List<State> expand = state.expand();
		assertEquals(4, expand.size());

		System.out.println(expand.get(0));

		System.out.println(expand.get(1));

		System.out.println(expand.get(2));

		System.out.println(expand.get(3));
	}
}
