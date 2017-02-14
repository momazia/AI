package com.sc.engine;

/**
 * Frontier is a place holder for all the chessmen in the game.
 * 
 * @author Mahdi Ziaee
 *
 */
public interface Frontier {

	/**
	 * Adds the given state into frontier
	 * 
	 * @param state
	 */
	public void addState(State state);

	/**
	 * Pops a state out of the frontier by removing it and returning the state.
	 * 
	 * @return
	 */
	public State pop();

	/**
	 * Checks to see if the frontier is empty. Returns true if it is.
	 * 
	 * @return
	 */
	public boolean isEmpty();
}
