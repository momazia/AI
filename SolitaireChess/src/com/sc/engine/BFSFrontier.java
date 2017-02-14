package com.sc.engine;

import java.util.LinkedList;
import java.util.Queue;

public class BFSFrontier implements Frontier {

	private Queue<State> states;

	public BFSFrontier() {
		states = new LinkedList<>();
	}

	@Override
	public State pop() {
		return states.poll();
	}

	@Override
	public void addState(State state) {
		states.add(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
