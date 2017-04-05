package com.marblesolitaire.engine;

public class MarbleSolitaireState implements State {

	private Boolean[][] spots;
	private int boardSize;

	public MarbleSolitaireState(int boardSize) {
		this.boardSize = boardSize;
		spots = new Boolean[boardSize][boardSize];
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		int boardSize = spots.length;
		for (int y = boardSize - 1; y >= 0; y--) {
			for (int x = 0; x < boardSize; x++) {
				if (Boolean.TRUE.equals(spots[x][y])) {
					result.append("O");
				} else if (Boolean.FALSE.equals(spots[x][y])) {
					result.append(" ");
				} else {
					result.append("X");
				}
			}
			result.append("\n");
		}
		return result.toString();
	}

	public void setSpot(int x, int y, Boolean value) {
		this.spots[x][y] = value;
	}

	public Boolean getSpot(int x, int y) {
		return this.spots[x][y];
	}

	public int getBoardSize() {
		return this.boardSize;
	}

	@Override
	public boolean isFinalState() {
		return false;
	}

}
