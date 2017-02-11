package com.sc.engine;

import java.util.ArrayList;
import java.util.List;

public class DFSFrontier implements Frontier {

	private List<State> states;

	public DFSFrontier() {
		states = new ArrayList<>();
	}

	@Override
	public State pop() {
		return states.get(0);
	}

	@Override
	public void addState(State state) {
		states.add(state);
	}

}
