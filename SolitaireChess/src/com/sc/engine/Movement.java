package com.sc.engine;

import com.sc.main.chessman.Chessman;
import com.sc.main.chessman.Location;

/**
 * This class represents a movement of a chessman on the board.
 * 
 * @author Mahdi Ziaee
 *
 */
public class Movement {

	private Location oldLocation;
	private Chessman chessman;

	public Movement(Location oldLocation, Chessman chessman) {
		super();
		this.oldLocation = oldLocation;
		this.chessman = chessman;
	}

	public Location getOldLocation() {
		return oldLocation;
	}

	public void setOldLocation(Location oldLocation) {
		this.oldLocation = oldLocation;
	}

	public Chessman getChessman() {
		return chessman;
	}

	public void setChessman(Chessman chessman) {
		this.chessman = chessman;
	}
}
