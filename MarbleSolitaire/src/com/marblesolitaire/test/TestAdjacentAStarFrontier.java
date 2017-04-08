package com.marblesolitaire.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marblesolitaire.main.AdjacentAStarFrontier;
import com.marblesolitaire.main.MarbleSolitaireEngine;
import com.marblesolitaire.main.MarbleSolitaireState;

public class TestAdjacentAStarFrontier {

	@Test
	public void testHeuristic1() {
		AdjacentAStarFrontier aStarFrontier = new AdjacentAStarFrontier();
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(aStarFrontier);

		assertEquals(2, aStarFrontier.calculateHeuristic(engine.createInitialState("./io/test/score0.txt")));
		assertEquals(0, aStarFrontier.calculateHeuristic(engine.createInitialState("./io/test/score1.txt")));
		assertEquals(8, aStarFrontier.calculateHeuristic(engine.createInitialState("./io/test/score2.txt")));
	}

	@Test
	public void testHeuristic2() {
		AdjacentAStarFrontier aStarFrontier = new AdjacentAStarFrontier();
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(aStarFrontier);

		MarbleSolitaireState result0 = engine.createInitialState("./io/test/score0.txt");
		aStarFrontier.add(result0);
		MarbleSolitaireState result1 = engine.createInitialState("./io/test/score1.txt");
		aStarFrontier.add(result1);
		MarbleSolitaireState result2 = engine.createInitialState("./io/test/score2.txt");
		aStarFrontier.add(result2);

		assertEquals(result2, aStarFrontier.pop());
		assertEquals(result0, aStarFrontier.pop());
		assertEquals(result1, aStarFrontier.pop());
	}
}
