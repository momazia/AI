package com.marblesolitaire.main;

import java.util.Stack;

import com.marblesolitaire.engine.BFSFrontier;
import com.marblesolitaire.engine.DFSFrontier;
import com.marblesolitaire.engine.Frontier;
import com.marblesolitaire.engine.State;

/**
 * The main application class to be executed in order to run different frontiers to solve the puzzle.
 * 
 * @author Mahdi Ziaee
 *
 */
public class MainApplication {

	/**
	 * Main method to be executed without any parameters passed.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Depth First Search Frontier
		runGame(new DFSFrontier<MarbleSolitaireState>());
		// Breadth First Search Frontier
		runGame(new BFSFrontier<MarbleSolitaireState>());
		// Modified Adjacent A* Frontier
		runGame(new ModifiedAdjacentAStarFrontier());
	}

	/**
	 * Runs the game for the given frontier passed. It loads the puzzle board data from "./io/test/small.txt" file.
	 * 
	 * @param frontier
	 */
	private static void runGame(Frontier<MarbleSolitaireState> frontier) {
		// Creating a new engine with the desire frontier
		MarbleSolitaireEngine engine = new MarbleSolitaireEngine(frontier);
		// Setting the input file path
		engine.setFilePath("./io/test/small.txt");
		// Instantiating the engine
		engine.initiate();
		// Running the engine and preparing the final result
		State finalState = engine.run();
		Stack<State> finalResult = reverse(finalState);
		// Printing the final result
		printResult(finalResult, engine.getVisitedNodes());
	}

	/**
	 * Prints the result of solving the puzzle.
	 * 
	 * @param finalResult
	 * @param numOfVisitedNodes
	 */
	private static void printResult(Stack<State> finalResult, int numOfVisitedNodes) {
		int numOfNodesToFinalAnswer = finalResult.size();
		while (!finalResult.isEmpty()) {
			State state = finalResult.pop();
			System.out.println(state);
			System.out.println("---------");
		}
		System.out.println("Number of nodes to the final answer: " + numOfNodesToFinalAnswer);
		System.out.println("Total visited nodes:" + numOfVisitedNodes);
	}

	/**
	 * Goes through the result in reverse order from the solution node back to the root and puts the final result into a stack.
	 * 
	 * @param finalState
	 * @return
	 */
	private static Stack<State> reverse(State finalState) {
		Stack<State> finalResult = new Stack<>();
		State state = finalState;
		do {
			finalResult.push(state);
			state = state.getPrevious();
		} while (state.getPrevious() != null);
		// Adding the last item
		finalResult.push(state);
		return finalResult;
	}
}
