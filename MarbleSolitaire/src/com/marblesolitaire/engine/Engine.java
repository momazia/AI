package com.marblesolitaire.engine;

import java.util.List;

public abstract class Engine<E extends State> {

	protected Frontier<E> frontier;
	private int visitedNodes;

	protected Engine() {
	}

	/**
	 * Uses the frontier class to create a new instance of the frontier.
	 * 
	 * @param frontierClass
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Engine(Frontier<E> frontier) {
		this.frontier = frontier;
		this.visitedNodes = 0;
	}

	public E run() {
		while (!frontier.isEmpty()) {
			E state = frontier.pop();
			visitedNodes++; // Incrementing the number of visited nodes.
			if (state.isFinalState()) {
				return state;
			}
			updateFrontier(state.expand());
		}
		return null;
	}

	private void updateFrontier(List<E> newStates) {
		for (E state : newStates) {
			frontier.add(state);
		}
	}

	public void initiate() {
		E initialState = createInitialState();
		frontier.add(initialState);
	}

	protected abstract E createInitialState();

	public int getVisitedNodes() {
		return visitedNodes;
	}

}
