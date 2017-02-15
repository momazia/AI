package com.sc.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sc.main.Result;
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
	public Result solve() throws InstantiationException, IllegalAccessException, NoSolutionFoundException {
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
	 * @throws NoSolutionFoundException
	 */
	public Result solveIteratively(int boardSize, Chessman[] chessmen)
			throws InstantiationException, IllegalAccessException, NoSolutionFoundException {
		// Instantiating the initial values
		int counter = 0;
		Result solution = new Result();
		List<State> exploredStates = new ArrayList<>();
		State initialState = new State(boardSize, 0, chessmen);
		do {
			// Creating a new frontier and adding the first state into the frontier.
			frontier = frontier.getClass().newInstance();
			frontier.addState(initialState);
			try {
				// Solving the problem with depth = counter
				solution = solve(counter);
				// Adding all the found solutions
				exploredStates.addAll(solution.getExploredStates());
			} catch (NoSolutionFoundException e) {
				// Checking to see if we might have gotten stuck by comparing what we have explored so far compare to
				// the last run. If they are the same, that means we have reach to the end of the tree and increasing
				// the counter won't help.
				if (exploredStates.containsAll(e.getExploredStates())) {
					throw e;
				}
				// When no result is found, add all those steps which were explored so far.
				exploredStates.addAll(e.getExploredStates());
			}
			counter++;
			// If solution is null, it means nothing is found.
		} while (solution.getExploredStates() == null);
		solution.setExploredStates(exploredStates);
		return solution;
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
	public Result solve(Integer maxDepthLimit) throws InstantiationException, IllegalAccessException, NoSolutionFoundException {
		List<State> exploredStates = new ArrayList<>();
		Stack<State> finalPath = new Stack<>();
		Result result = new Result();
		while (!frontier.isEmpty()) {
			State currentState = frontier.pop();
			if (maxDepthLimit != null && currentState.getLevel() > maxDepthLimit) {
				continue;
			}
			exploredStates.add(currentState);
			updatePath(finalPath, currentState);
			if (currentState.isGoal()) {
				result.setExploredStates(exploredStates);
				result.setFinalPath(finalPath);
				return result;
			}
			for (State state : currentState.getPossibleStates()) {
				state.setLevel(currentState.getLevel() + 1);
				frontier.addState(state);
			}
		}
		throw new NoSolutionFoundException(exploredStates);
	}

	/**
	 * Updates the final path based on the level we are at.
	 * 
	 * @param finalPath
	 * @param currentState
	 */
	public void updatePath(Stack<State> finalPath, State currentState) {
		Integer previousLevel = finalPath.isEmpty() ? -1 : finalPath.peek().getLevel();
		Integer currentLevel = currentState.getLevel();
		if (currentLevel == previousLevel) {
			// we are moving horizontally, removing the last added state and adding the current one.
			finalPath.pop();
		} else if (currentLevel < previousLevel) {
			// we are moving up, we need to see how many levels we are moving up so we can remove them
			for (int i = 0; i <= previousLevel - currentLevel; i++) {
				finalPath.pop();
			}
		}
		finalPath.push(currentState);
	}

}
