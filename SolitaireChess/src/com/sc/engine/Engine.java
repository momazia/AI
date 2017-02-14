package com.sc.engine;

import java.util.ArrayList;
import java.util.List;

import com.sc.main.chessman.Chessman;

/**
 * The main game engine which handles the states of the game.
 * 
 * @author Mahdi Ziaee
 *
 */
public class Engine {

	private Frontier frontier;

	/**
	 * Uses the frontier class to create a new instance of the frontier.
	 * 
	 * @param frontierClass
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Engine(Class<? extends Frontier> frontierClass) throws InstantiationException, IllegalAccessException {
		frontier = frontierClass.newInstance();
	}

	/**
	 * For the given list of chessmen and board size, it creates the first state and adds it into the frontier.
	 * 
	 * @param boardSize
	 * @param chessmen
	 */
	public void initiate(int boardSize, Chessman... chessmen) {
		State initialState = new State(boardSize, 0, chessmen);
		frontier.addState(initialState);
	}

	/**
	 * Solves the puzzle without any limitations.
	 * 
	 * @return The number of total states visited.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSolutionFoundException
	 *             if it cannot find a solution to the problem.
	 */
	public List<State> solve() throws InstantiationException, IllegalAccessException, NoSolutionFoundException {
		return solve(null);
	}

	/**
	 * Solves the problem using the board size and the list of chessmen iteratively by first checking the initial state
	 * and gradually increasing the depth in which the engine will look for the final answer.
	 * 
	 * @param boardSize
	 * @param chessmen
	 * @return The number of total states visited.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<State> solveIteratively(int boardSize, Chessman[] chessmen) throws InstantiationException, IllegalAccessException {
		// Instantiating the initial values
		int counter = 0;
		List<State> solution = null;
		List<State> result = new ArrayList<>();
		State initialState = new State(boardSize, 0, chessmen);
		do {
			// Creating a new frontier and adding the first state into the frontier.
			frontier = frontier.getClass().newInstance();
			frontier.addState(initialState);
			try {
				// Solving the problem with depth = counter
				solution = solve(counter);
				// Adding all the found solutions
				result.addAll(solution);
			} catch (NoSolutionFoundException e) {
				// When no result is found, add all those steps which were explored, looking for the answer.
				result.addAll(e.getExploredStates());
			}
			counter++;
			// If solution is null, it means nothing is found. Continue the search.
		} while (solution == null);
		return result;
	}

	/**
	 * Uses the maximum depth limit passed to go through the tree. It won't go lower than the maximum depth limit to
	 * find the solution.
	 * 
	 * @param maxDepthLimit
	 * @return The number of total states visited.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSolutionFoundException
	 *             if it cannot find a solution to the problem.
	 */
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
