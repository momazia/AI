package com.sc.main.chessman;

import java.util.List;

import com.sc.main.CustomArrayList;

/**
 * Represents a chessman in the puzzle. This class is to be extended by the actual pieces.
 * 
 * @author Mahdi Ziaee
 *
 */
public abstract class Chessman {

	private Location location;

	public Chessman() {
	}

	public Chessman(int x, int y) {
		this.setLocation(new Location(x, y));
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;

		if (!(o instanceof Chessman)) {
			return false;
		}

		Chessman chessman = (Chessman) o;
		// Two chessmen are the same if they are of the same type AND they are on the same location.
		return chessman.getLocation().equals(this.getLocation());
	}

	/**
	 * This method returns a list of victims which can be taken down by the current chessman at any point in time.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public abstract List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize);

	/**
	 * Checks up right, up left, down right and down left movements of a diagonal movement to see if there is any victim
	 * which can be taken down.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public List<Chessman> diagonalMovement(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new CustomArrayList<>();
		result.add(upRight(chessmen, boardSize));
		result.add(upLeft(chessmen, boardSize));
		result.add(downRight(chessmen, boardSize));
		result.add(downLeft(chessmen, boardSize));
		return result;
	}

	/**
	 * Checks to see if there is any chessman in down left side of the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman downLeft(List<Chessman> chessmen, int boardSize) {
		for (int counter = 1; counter <= boardSize - Math.min(getLocation().getX(), getLocation().getY()); counter++) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getX() == getLocation().getX() - counter
						&& boardChessman.getLocation().getY() == getLocation().getY() - counter) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is any chessman in down right side of the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman downRight(List<Chessman> chessmen, int boardSize) {
		for (int counter = 1; counter <= boardSize - Math.min(getLocation().getX(), getLocation().getY()); counter++) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getX() == getLocation().getX() + counter
						&& boardChessman.getLocation().getY() == getLocation().getY() - counter) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is any chessman in up left side of the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman upLeft(List<Chessman> chessmen, int boardSize) {
		for (int counter = 1; counter <= boardSize - Math.min(getLocation().getX(), getLocation().getY()); counter++) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getX() == getLocation().getX() - counter
						&& boardChessman.getLocation().getY() == getLocation().getY() + counter) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is any chessman in up right side of the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman upRight(List<Chessman> chessmen, int boardSize) {
		for (int counter = 1; counter <= boardSize - Math.max(getLocation().getX(), getLocation().getY()); counter++) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getX() == getLocation().getX() + counter
						&& boardChessman.getLocation().getY() == getLocation().getY() + counter) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Returns a list of victims aligned horizontally or vertically based on the current chessman's location.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public List<Chessman> plusMovement(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new CustomArrayList<>();
		result.add(up(chessmen, boardSize));
		result.add(down(chessmen, boardSize));
		result.add(left(chessmen, boardSize));
		result.add(right(chessmen, boardSize));
		return result;
	}

	/**
	 * Checks to see if there is any chessman at left side of the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman left(List<Chessman> chessmen, int boardSize) {
		for (int x = getLocation().getX() - 1; x > 0; x--) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getY() == getLocation().getY() && boardChessman.getLocation().getX() == x) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is any chessman at right side of the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman right(List<Chessman> chessmen, int boardSize) {
		for (int x = getLocation().getX() + 1; x <= boardSize; x++) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getY() == getLocation().getY() && boardChessman.getLocation().getX() == x) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is any chessman above the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman up(List<Chessman> chessmen, int boardSize) {
		for (int y = getLocation().getY() + 1; y <= boardSize; y++) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getY() == y && boardChessman.getLocation().getX() == getLocation().getX()) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/**
	 * Checks to see if there is any chessman below the current piece.
	 * 
	 * @param chessmen
	 * @param boardSize
	 * @return
	 */
	public Chessman down(List<Chessman> chessmen, int boardSize) {
		for (int y = getLocation().getY() - 1; y > 0; y--) {
			for (Chessman boardChessman : chessmen) {
				if (boardChessman.getLocation().getY() == y && boardChessman.getLocation().getX() == getLocation().getX()) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getLocation().toString();
	}

}
