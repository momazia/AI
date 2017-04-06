package com.marblesolitaire.engine;

import java.util.Stack;

/**
 * Depth first search (DFS) uses a stack as a frontier.
 * 
 * @author Mahdi Ziaee
 *
 */
public class DFSFrontier<E extends State> implements Frontier<E> {

	private Stack<E> states;

	public DFSFrontier() {
		states = new Stack<>();
	}

	@Override
	public E pop() {
		return states.pop();
	}

	@Override
	public void add(E state) {
		states.push(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
