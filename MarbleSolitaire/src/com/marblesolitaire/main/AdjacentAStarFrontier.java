package com.marblesolitaire.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.marblesolitaire.engine.Frontier;

/**
 * Adjacent A Star frontier looks at each of the marbles on the board and counts the total number of adjacent marbles to each other.
 * 
 * @author Mahdi Ziaee
 *
 */
public class AdjacentAStarFrontier implements Frontier<MarbleSolitaireState> {

	protected List<MarbleSolitaireState> states;
	protected int maxHeuristicScore = -1;

	/**
	 * Default constructor.
	 */
	public AdjacentAStarFrontier() {
		this.states = new LinkedList<>();
	}

	@Override
	public MarbleSolitaireState pop() {
		// Finding the highest score based on the adjacent nodes
		int localMaxScore = -1;
		MarbleSolitaireState result = null;
		// Going through all the states
		for (MarbleSolitaireState marbleSolitaireState : states) {
			// Calculating the state score
			int heuristicScore = calculateHeuristic(marbleSolitaireState);
			int score = calculateStateScore(heuristicScore, marbleSolitaireState.getPath());
			// Finding the maximum score and the state having such score
			if (localMaxScore < score) {
				localMaxScore = score;
				result = marbleSolitaireState;
			}
			if (maxHeuristicScore < heuristicScore) {
				maxHeuristicScore = heuristicScore;
			}
		}
		// Removing the state with maximum score from the list and returning it
		Iterator<MarbleSolitaireState> iterator = states.iterator();
		while (iterator.hasNext()) {
			MarbleSolitaireState item = iterator.next();
			if (item.equals(result)) {
				iterator.remove();
				return result;
			}
		}
		return null;
	}

	/**
	 * Calculating the score by adding the heuristic score to the path cost.
	 * 
	 * @param heuristicScore
	 * @param path
	 * @return
	 */
	protected int calculateStateScore(int heuristicScore, int path) {
		return heuristicScore + path;
	}

	/**
	 * Calculates the heuristic score of the given state by counting the total number of adjacent marbles to each of the marbles on the board. The
	 * higher the score, the more marbles are next to each other.
	 * 
	 * @param marbleSolitaireState
	 * @return
	 */
	public int calculateHeuristic(MarbleSolitaireState marbleSolitaireState) {
		int result = 0;
		int boardSize = marbleSolitaireState.getBoardSize();
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (Boolean.TRUE.equals(marbleSolitaireState.getSpot(x, y))) {
					// Up
					if (y < boardSize - 1 && Boolean.TRUE.equals(marbleSolitaireState.getSpot(x, y + 1))) {
						result++;
					}
					// Down
					if (y > 0 && Boolean.TRUE.equals(marbleSolitaireState.getSpot(x, y - 1))) {
						result++;
					}
					// Right
					if (x < boardSize - 1 && Boolean.TRUE.equals(marbleSolitaireState.getSpot(x + 1, y))) {
						result++;
					}
					// Left
					if (x > 0 && Boolean.TRUE.equals(marbleSolitaireState.getSpot(x - 1, y))) {
						result++;
					}
				}
			}
		}
		return result;
	}

	@Override
	public void add(MarbleSolitaireState state) {
		states.add(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
