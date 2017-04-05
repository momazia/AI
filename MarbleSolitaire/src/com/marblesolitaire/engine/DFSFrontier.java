package com.marblesolitaire.engine;

import java.util.Stack;

/**
 * Depth first search (DFS) uses a stack as a frontier.
 * 
 * @author Mahdi Ziaee
 *
 */
public class DFSFrontier implements Frontier {

	private Stack<MarbleSolitaireState> states;

	public DFSFrontier() {
		states = new Stack<>();
	}

	@Override
	public MarbleSolitaireState pop() {
		return states.pop();
	}

	@Override
	public void add(MarbleSolitaireState state) {
		states.push(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
