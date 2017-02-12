package com.sc.engine;

import com.sc.main.chessman.Chessman;

public class Engine {

	private Frontier frontier;

	public Engine() {
		frontier = new DFSFrontier();
	}

	public void initiate(int boardSize, Chessman... chessmans) {
		frontier.addState(new State(boardSize, chessmans));
	}

	public int solve() {
		int counter = 0;
		State initialState = frontier.pop();
		for (State state : initialState.getPossibleStates()) {

		}
		return counter;
	}

}
