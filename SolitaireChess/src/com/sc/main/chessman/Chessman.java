package com.sc.main.chessman;

import java.util.List;

import com.sc.main.CustomArrayList;

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

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;

		if (!(o instanceof Chessman)) {
			return false;
		}

		Chessman chessman = (Chessman) o;
		return chessman.getLocation().equals(this.getLocation());
	}

	public abstract List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize);

	public List<Chessman> crossMovement(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new CustomArrayList<>();
		result.add(upRight(chessmen, boardSize));
		result.add(upLeft(chessmen, boardSize));
		result.add(downRight(chessmen, boardSize));
		result.add(downLeft(chessmen, boardSize));
		return result;
	}

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

	public List<Chessman> plusMovement(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new CustomArrayList<>();
		result.add(up(chessmen, boardSize));
		result.add(down(chessmen, boardSize));
		result.add(left(chessmen, boardSize));
		result.add(right(chessmen, boardSize));
		return result;
	}

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

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getLocation().toString();
	}

}
