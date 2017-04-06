package com.marblesolitaire.engine;

import java.util.List;

public abstract class State {

	private State previous;

	public abstract boolean isFinalState();
	
	public abstract List<State> expand();

	public State getPrevious() {
		return previous;
	}

	public void setPrevious(State previous) {
		this.previous = previous;
	}
}
