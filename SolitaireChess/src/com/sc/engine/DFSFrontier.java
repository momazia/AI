package com.sc.engine;

import java.util.Stack;

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
