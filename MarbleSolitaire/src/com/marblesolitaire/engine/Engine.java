package com.marblesolitaire.engine;

import java.util.List;

public abstract class Engine {

	protected Frontier<State> frontier;

	/**
	 * Uses the frontier class to create a new instance of the frontier.
	 * 
	 * @param frontierClass
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Engine(Frontier<State> frontier) {
		this.frontier = frontier;
	}

	public State run() {
		while (!frontier.isEmpty()) {
			State state = frontier.pop();
			if (state.isFinalState()) {
				return state;
			}
			updateFrontier(state.expand());
		}
		return null;
	}

	private void updateFrontier(List<State> newStates) {
		for (State state : newStates) {
			frontier.add(state);
		}
	}

	public void initiate() {
		State initialState = createInitialState();
		frontier.add(initialState);
	}

	protected abstract State createInitialState();

}
