package com.sc.engine;

import java.util.Stack;

/**
 * Depth first search (DFS) uses a stack as a frontier.
 * 
 * @author Mahdi Ziaee
 *
 */
public class DFSFrontier implements Frontier {

	private Stack<State> states;

	public DFSFrontier() {
		states = new Stack<>();
	}

	@Override
	public State pop() {
		return states.pop();
	}

	@Override
	public void addState(State state) {
		states.push(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
