package com.sc.engine;

public interface Frontier {

	public void addState(State state);

	public State pop();
}
