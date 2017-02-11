package com.sc.main.chessman;

public abstract class Chessman {

	private Location location;

	public Location getLocation() {
		return location;
	}

	public Chessman(int x, int y) {
		this.location = new Location(x, y);
	}

	public abstract boolean canTakeDown(Chessman boardChessman);

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

}
