package com.sc.engine;

import java.util.ArrayList;
import java.util.List;

import com.sc.main.chessman.Chessman;

public class Engine {

	private Frontier frontier;

	public Engine(Class<? extends Frontier> frontierClass) throws InstantiationException, IllegalAccessException {
		frontier = frontierClass.newInstance();
	}

	public void initiate(int boardSize, Chessman... chessmen) {
		State initialState = new State(boardSize, 0, chessmen);
		frontier.addState(initialState);
	}

	public List<State> solve() throws InstantiationException, IllegalAccessException, NoSolutionFoundException {
		return solve(null);
	}

	public List<State> solveIteratively(int boardSize, Chessman[] chessmen) throws InstantiationException, IllegalAccessException {
		int counter = 0;
		List<State> solution = null;
		List<State> result = new ArrayList<>();
		State initialState = new State(boardSize, 0, chessmen);
		do {
			frontier = frontier.getClass().newInstance();
			frontier.addState(initialState);
			try {
				solution = solve(counter);
				result.addAll(solution);
			} catch (NoSolutionFoundException e) {
				result.addAll(e.getExploredStates());
			}
			counter++;
		} while (solution == null);
		return result;
	}

	public List<State> solve(Integer maxDepthLimit) throws InstantiationException, IllegalAccessException, NoSolutionFoundException {
		List<State> result = new ArrayList<>();
		while (!frontier.isEmpty()) {
			State currentState = frontier.pop();
			if (maxDepthLimit != null && currentState.getLevel() > maxDepthLimit) {
				continue;
			}
			result.add(currentState);
			if (currentState.isGoal()) {
				return result;
			}
			for (State state : currentState.getPossibleStates()) {
				state.setLevel(currentState.getLevel() + 1);
				frontier.addState(state);
			}
		}
		throw new NoSolutionFoundException(result);
	}

}
