package com.sc.main;

import java.util.List;

import com.sc.engine.AStarFrontier;
import com.sc.engine.BFSFrontier;
import com.sc.engine.DFSFrontier;
import com.sc.engine.Engine;
import com.sc.engine.NoSolutionFoundException;
import com.sc.engine.State;
import com.sc.main.chessman.Bishop;
import com.sc.main.chessman.Knight;
import com.sc.main.chessman.Pawn;
import com.sc.main.chessman.Queen;
import com.sc.main.chessman.Rook;

/**
 * The main application to be executed to run the different tests.
 * 
 * @author Mahdi Ziaee
 *
 */
public class MainApplication {

	private static Puzzle[] puzzles = new Puzzle[] {
			// DFS Frontier, Not iterative
			new Puzzle(4, false, DFSFrontier.class, new Bishop(2, 3), new Rook(1, 2), new Pawn(2, 2), new Knight(4, 1)),
			new Puzzle(4, false, DFSFrontier.class, new Bishop(1, 1), new Bishop(2, 3), new Queen(3, 4), new Knight(4, 4)),
			new Puzzle(4, false, DFSFrontier.class, new Bishop(1, 4), new Knight(3, 4), new Knight(1, 3), new Queen(2, 3), new Pawn(2, 1)),
			// BFS Frontier, Not iterative
			new Puzzle(4, false, BFSFrontier.class, new Bishop(2, 3), new Rook(1, 2), new Pawn(2, 2), new Knight(4, 1)),
			new Puzzle(4, false, BFSFrontier.class, new Bishop(1, 1), new Bishop(2, 3), new Queen(3, 4), new Knight(4, 4)),
			new Puzzle(4, false, BFSFrontier.class, new Bishop(1, 4), new Knight(3, 4), new Knight(1, 3), new Queen(2, 3), new Pawn(2, 1)),
			// A* Frontier, Not iterative
			new Puzzle(4, false, AStarFrontier.class, new Bishop(2, 3), new Rook(1, 2), new Pawn(2, 2), new Knight(4, 1)),
			new Puzzle(4, false, AStarFrontier.class, new Bishop(1, 1), new Bishop(2, 3), new Queen(3, 4), new Knight(4, 4)),
			new Puzzle(4, false, AStarFrontier.class, new Bishop(1, 4), new Knight(3, 4), new Knight(1, 3), new Queen(2, 3), new Pawn(2, 1)),
			// DFS Frontier, iterative
			new Puzzle(4, true, DFSFrontier.class, new Bishop(2, 3), new Rook(1, 2), new Pawn(2, 2), new Knight(4, 1)),
			new Puzzle(4, true, DFSFrontier.class, new Bishop(1, 1), new Bishop(2, 3), new Queen(3, 4), new Knight(4, 4)),
			new Puzzle(4, true, DFSFrontier.class, new Bishop(1, 4), new Knight(3, 4), new Knight(1, 3), new Queen(2, 3), new Pawn(2, 1)),
			// A* Frontier, iterative
			new Puzzle(4, true, AStarFrontier.class, new Bishop(2, 3), new Rook(1, 2), new Pawn(2, 2), new Knight(4, 1)),
			new Puzzle(4, true, AStarFrontier.class, new Bishop(1, 1), new Bishop(2, 3), new Queen(3, 4), new Knight(4, 4)),
			new Puzzle(4, true, AStarFrontier.class, new Bishop(1, 4), new Knight(3, 4), new Knight(1, 3), new Queen(2, 3), new Pawn(2, 1)), };

	/**
	 * Main method to be executed to solve the puzzles.
	 * 
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		for (Puzzle puzzle : puzzles) {
			// Creating a new engine
			Engine engine = new Engine(puzzle.getFrontier());
			List<State> result = null;
			if (puzzle.isIterative()) {
				// Solving the problem iteratively
				result = engine.solveIteratively(puzzle.getBoardSize(), puzzle.getChessmen());
				// Printing the result
				printResult(puzzle, result);
			} else {
				// Initializing the values
				engine.initiate(puzzle.getBoardSize(), puzzle.getChessmen());
				try {
					// Solving the puzzle
					result = engine.solve();
					// Printing the result
					printResult(puzzle, result);
				} catch (NoSolutionFoundException e) {
					// If no solution found!
					System.out.println("No solution found! Total number of nodes visited: " + e.getExploredStates().size());
				}
			}
		}
	}

	private static void printResult(Puzzle puzzle, List<State> result) {
		System.out.println(puzzle + ". Total number of nodes visited: " + result.size());
	}

}
