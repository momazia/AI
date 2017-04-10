package com.marblesolitaire.engine;

import java.util.List;

/**
 * State class is to be extended by all the custom states.
 * 
 * @author Mahdi Ziaee
 *
 */
public abstract class State {

	private State previous;

	/**
	 * Validates to see if this is the final state.
	 * 
	 * @return
	 */
	public abstract boolean isFinalState();

	/**
	 * Expands the current node and returns the list of nodes expanded.
	 * 
	 * @return
	 */
	public abstract <E extends State> List<E> expand();

	public State getPrevious() {
		return previous;
	}

	public void setPrevious(State previous) {
		this.previous = previous;
	}

	/**
	 * Returns the path to the current state
	 * 
	 * @return
	 */
	public abstract int getPath();

}
