package com.sc.engine;

import java.util.List;

/**
 * A custom exception to be used when no solution is found for the puzzle given. It holds the list of explored states
 * too.
 * 
 * @author Mahdi Ziaee
 *
 */
public class NoSolutionFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1346684380149207754L;

	private List<State> exploredStates;

	public NoSolutionFoundException(List<State> exploredStates) {
		this.exploredStates = exploredStates;
	}

	public List<State> getExploredStates() {
		return exploredStates;
	}

	public void setExploredStates(List<State> exploredStates) {
		this.exploredStates = exploredStates;
	}

}
