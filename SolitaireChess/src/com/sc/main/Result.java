package com.sc.main;

import java.util.List;

import com.sc.engine.State;

public class Result {

	private List<State> exploredStates;
	private List<State> finalPath;

	public List<State> getExploredStates() {
		return exploredStates;
	}

	public void setExploredStates(List<State> exploredStates) {
		this.exploredStates = exploredStates;
	}

	public List<State> getFinalPath() {
		return finalPath;
	}

	public void setFinalPath(List<State> finalPath) {
		this.finalPath = finalPath;
	}

}
