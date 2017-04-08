package com.marblesolitaire.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.marblesolitaire.engine.Frontier;

public class ModifiedAdjacentAStarFrontier implements Frontier<MarbleSolitaireState> {

	private List<MarbleSolitaireState> states;
	private Integer maxScore = null;

	public ModifiedAdjacentAStarFrontier() {
		this.states = new LinkedList<>();
	}

	@Override
	public MarbleSolitaireState pop() {
		// Finding the highest score based on the adjacent nodes
		int maxScore = -1;
		MarbleSolitaireState result = null;
		for (MarbleSolitaireState marbleSolitaireState : states) {
			int score = calculateHeuristic(marbleSolitaireState) + maxScore * marbleSolitaireState.getPath();
			if (maxScore < score) {
				maxScore = score;
				result = marbleSolitaireState;
			}
		}
		// Removing the state from the list
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
		if (maxScore == null) {
			maxScore = calculateHeuristic(state);
		}
		states.add(state);
	}

	@Override
	public boolean isEmpty() {
		return states.isEmpty();
	}

}
