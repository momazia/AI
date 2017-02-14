package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class represents a Pawn chessman. It can only go top left or top right.
 * 
 * @author Mahdi Ziaee
 *
 */
public class Pawn extends Chessman {

	public Pawn() {
		super();
	}

	public Pawn(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmen) {
			if (!this.equals(chessman) && (Math.abs(chessman.getLocation().getX() - getLocation().getX()) == 1
					&& chessman.getLocation().getY() - getLocation().getY() == 1)) {
				result.add(chessman);
			}
		}
		return result;
	}

}
