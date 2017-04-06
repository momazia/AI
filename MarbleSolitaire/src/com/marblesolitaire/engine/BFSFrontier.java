package com.marblesolitaire.engine;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth first search (BFS) uses a linked list queue as frontier.
 * 
 * @author Mahdi Ziaee
 *
 */
public class BFSFrontier<E extends State> implements Frontier<E> {

	private Queue<E> states;

	public BFSFrontier() {
		states = new LinkedList<>();
	}

	@Override
	public E pop() {
		return states.poll();
	}

	@Override
	public void add(E state) {
		states.add(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
