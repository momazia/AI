package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a king chessman. It moves one square in any direction.
 * 
 * @author Mahdi Ziaee
 *
 */
public class King extends Chessman {

	public King() {
		super();
	}

	public King(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmen) {
			if (!chessman.equals(this) && Math.abs(chessman.getLocation().getX() - this.getLocation().getX()) < 2
					&& Math.abs(chessman.getLocation().getY() - this.getLocation().getY()) < 2) {
				result.add(chessman);
			}
		}
		return result;
	}

}
