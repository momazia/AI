package com.sc.engine;

import com.sc.main.chessman.Chessman;

public class Engine {

	private int size;
	private Frontier frontier;

	public Engine(int size) {
		this.size = size;
		frontier = new DFSFrontier();
	}

	public void initiate(Chessman... chessmans) {
		frontier.addState(new State(chessmans));
	}

	public int solve() {
		int counter = 0;
		State initialState = frontier.pop();
		for (State state : initialState.getPossibleStates()) {
			
		}
		return counter;
	}

}
