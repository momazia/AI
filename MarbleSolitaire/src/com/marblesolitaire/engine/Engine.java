package com.marblesolitaire.engine;

import java.util.List;

/**
 * Engine class must be extended by all the custom engines created in the application.
 * 
 * @author Mahdi Ziaee
 *
 * @param <E>
 */
public abstract class Engine<E extends State> {

	protected Frontier<E> frontier;
	private int visitedNodes;

	/**
	 * Inaccessible default constructor.
	 */
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

	/**
	 * Runs the game by popping states from the frontier and expanding the visited nodes. Returns null if it finds no solution.
	 * 
	 * @return
	 */
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

	/**
	 * Adds the given list of new states into the frontier.
	 * 
	 * @param newStates
	 */
	private void updateFrontier(List<E> newStates) {
		for (E state : newStates) {
			frontier.add(state);
		}
	}

	/**
	 * Initiates the engine by creating the initial state and adding it into the frontier.
	 */
	public void initiate() {
		E initialState = createInitialState();
		frontier.add(initialState);
	}

	/**
	 * Creates the initial state which will be at the root of the search tree.
	 * 
	 * @return
	 */
	protected abstract E createInitialState();

	/**
	 * Returns the total number of nodes visited.
	 * 
	 * @return
	 */
	public int getVisitedNodes() {
		return visitedNodes;
	}

}
