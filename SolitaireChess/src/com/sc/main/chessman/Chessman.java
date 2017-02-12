package com.sc.main.chessman;

import java.util.List;

import com.sc.main.CustomArrayList;

public abstract class Chessman {

	private Location location;

	public Location getLocation() {
		return location;
	}

	public Chessman(int x, int y) {
		this.location = new Location(x, y);
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

	public abstract List<Chessman> getPossibleVictims(Chessman[] chessmans, int boardSize);

	public List<Chessman> crossMovement(Chessman[] chessmans, int boardSize) {
		List<Chessman> result = new CustomArrayList<>();
		result.add(upRight(chessmans, boardSize));
		result.add(upLeft(chessmans, boardSize));
		result.add(downRight(chessmans, boardSize));
		result.add(downLeft(chessmans, boardSize));
		return result;
	}

	private Chessman downLeft(Chessman[] chessmans, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private Chessman downRight(Chessman[] chessmans, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private Chessman upLeft(Chessman[] chessmans, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private Chessman upRight(Chessman[] chessmans, int boardSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Chessman> plusMovement(Chessman[] chessmans, int boardSize) {
		List<Chessman> result = new CustomArrayList<>();
		result.add(up(chessmans, boardSize));
		result.add(down(chessmans, boardSize));
		result.add(left(chessmans, boardSize));
		result.add(right(chessmans, boardSize));
		return result;
	}

	public Chessman left(Chessman[] chessmans, int boardSize) {
		for (int x = location.getX() - 1; x > 0; x--) {
			for (Chessman boardChessman : chessmans) {
				if (boardChessman.getLocation().getY() == location.getY() && boardChessman.getLocation().getX() == x) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	public Chessman right(Chessman[] chessmans, int boardSize) {
		for (int x = location.getX() + 1; x <= boardSize; x++) {
			for (Chessman boardChessman : chessmans) {
				if (boardChessman.getLocation().getY() == location.getY() && boardChessman.getLocation().getX() == x) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	public Chessman up(Chessman[] chessmans, int boardSize) {
		for (int y = location.getY() + 1; y <= boardSize; y++) {
			for (Chessman boardChessman : chessmans) {
				if (boardChessman.getLocation().getY() == y && boardChessman.getLocation().getX() == location.getX()) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	public Chessman down(Chessman[] chessmans, int boardSize) {
		for (int y = location.getY() - 1; y > 0; y--) {
			for (Chessman boardChessman : chessmans) {
				if (boardChessman.getLocation().getY() == y && boardChessman.getLocation().getX() == location.getX()) {
					return boardChessman;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + location.toString();
	}

}
