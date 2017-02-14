package com.sc.main.chessman;

/**
 * Location class represents a location on the board. It contains x and y coordinate of a chessman.
 * 
 * @author Mahdi Ziaee
 *
 */
public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

		if (!(o instanceof Location)) {
			return false;
		}

		Location location = (Location) o;
		// Two locations are the same if they have the same x and y.
		return location.getX() == getX() && location.getY() == getY();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
