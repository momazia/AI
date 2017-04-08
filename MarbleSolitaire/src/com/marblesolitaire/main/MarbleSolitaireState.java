package com.marblesolitaire.main;

import java.util.List;

import com.marblesolitaire.engine.CustomArrayList;
import com.marblesolitaire.engine.State;

public class MarbleSolitaireState extends State {

	private Boolean[][] spots;
	private int boardSize;
	private int path;

	public MarbleSolitaireState(int boardSize) {
		this.boardSize = boardSize;
		setSpots(new Boolean[boardSize][boardSize]);
		this.setPath(0);
	}

	private MarbleSolitaireState createStateCopy() {
		MarbleSolitaireState copy = new MarbleSolitaireState(boardSize);
		Boolean[][] newSpots = new Boolean[boardSize][boardSize];
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				newSpots[x][y] = getSpot(x, y);
			}
		}
		copy.setSpots(newSpots);
		copy.setPrevious(this.getPrevious());
		copy.setPath(this.getPath());
		return copy;
	}

	public MarbleSolitaireState moveUp(int x, int y) {
		if (y < boardSize - 2 && Boolean.FALSE.equals(getSpots()[x][y + 2]) && Boolean.TRUE.equals(getSpots()[x][y + 1])) {
			// We can move this marble and create a new state by jumping the marble over the top one
			MarbleSolitaireState newState = createStateCopy();
			newState.setSpot(x, y, false); // The old position is now empty
			newState.setSpot(x, y + 1, false); // The position above is now empty too
			newState.setSpot(x, y + 2, true); // The marble is now occupying a new position
			newState.setPrevious(this);
			newState.setPath(this.getPath() + 1);
			return newState;
		}
		return null;
	}

	public MarbleSolitaireState moveDown(int x, int y) {
		if (y > 1 && Boolean.FALSE.equals(getSpots()[x][y - 2]) && Boolean.TRUE.equals(getSpots()[x][y - 1])) {
			// We can move this marble and create a new state by jumping the marble over the bottom one
			MarbleSolitaireState newState = createStateCopy();
			newState.setSpot(x, y, false); // The old position is now empty
			newState.setSpot(x, y - 1, false); // The position below is now empty too
			newState.setSpot(x, y - 2, true); // The marble is now occupying a new position
			newState.setPrevious(this);
			newState.setPath(this.getPath() + 1);
			return newState;
		}
		return null;
	}

	public MarbleSolitaireState moveRight(int x, int y) {
		if (x < boardSize - 2 && Boolean.FALSE.equals(getSpots()[x + 2][y]) && Boolean.TRUE.equals(getSpots()[x + 1][y])) {
			// We can move this marble and create a new state by jumping the marble over the right one
			MarbleSolitaireState newState = createStateCopy();
			newState.setSpot(x, y, false); // The old position is now empty
			newState.setSpot(x + 1, y, false); // The position next to the marble is now empty too
			newState.setSpot(x + 2, y, true); // The marble is now occupying a new position
			newState.setPrevious(this);
			newState.setPath(this.getPath() + 1);
			return newState;
		}
		return null;
	}

	public MarbleSolitaireState moveLeft(int x, int y) {
		if (x > 1 && Boolean.FALSE.equals(getSpots()[x - 2][y]) && Boolean.TRUE.equals(getSpots()[x - 1][y])) {
			// We can move this marble and create a new state by jumping the marble over the left one
			MarbleSolitaireState newState = createStateCopy();
			newState.setSpot(x, y, false); // The old position is now empty
			newState.setSpot(x - 1, y, false); // The position next to the marble is now empty too
			newState.setSpot(x - 2, y, true); // The marble is now occupying a new position
			newState.setPrevious(this);
			newState.setPath(this.getPath() + 1);
			return newState;
		}
		return null;
	}

	@Override
	public List<State> expand() {
		List<State> states = new CustomArrayList<>();
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (Boolean.TRUE.equals(getSpots()[x][y])) {
					// Means we are looking at a marble in (x,y)
					states.add(moveUp(x, y));
					states.add(moveDown(x, y));
					states.add(moveLeft(x, y));
					states.add(moveRight(x, y));
				}
			}
		}
		return states;
	}

	@Override
	public boolean isFinalState() {
		int countMarbles = 0;
		for (Boolean[] rows : getSpots()) {
			for (Boolean spot : rows) {
				if (Boolean.TRUE.equals(spot)) {
					countMarbles++;
				}
				if (countMarbles > 1) {
					return false;
				}
			}
		}
		return countMarbles == 1;
	}

	public void setSpot(int x, int y, Boolean value) {
		this.getSpots()[x][y] = value;
	}

	public Boolean getSpot(int x, int y) {
		return this.getSpots()[x][y];
	}

	public int getBoardSize() {
		return this.boardSize;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		int boardSize = getSpots().length;
		for (int y = boardSize - 1; y >= 0; y--) {
			for (int x = 0; x < boardSize; x++) {
				if (Boolean.TRUE.equals(getSpots()[x][y])) {
					result.append("O ");
				} else if (Boolean.FALSE.equals(getSpots()[x][y])) {
					result.append("  ");
				} else {
					result.append("X ");
				}
			}
			result.append("\n");
		}
		return result.toString();
	}

	public Boolean[][] getSpots() {
		return spots;
	}

	public void setSpots(Boolean[][] spots) {
		this.spots = spots;
	}

	@Override
	public int getPath() {
		return this.path;
	}

	public void setPath(int path) {
		this.path = path;
	}

}
