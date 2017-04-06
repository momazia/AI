package com.marblesolitaire.engine;

/**
 * Frontier is a place holder for all the possible states in the game
 * 
 * @author Mahdi Ziaee
 * @param <E>
 *            This parameter is the type of the state
 */
public interface Frontier<E extends State> {

	/**
	 * Adds the given state into frontier
	 * 
	 * @param state
	 */
	public void add(E state);

	/**
	 * Pops a state out of the frontier by removing it and returning the state.
	 * 
	 * @return
	 */
	public E pop();

	/**
	 * Checks to see if the frontier is empty. Returns true if it is.
	 * 
	 * @return
	 */
	public boolean isEmpty();

}
