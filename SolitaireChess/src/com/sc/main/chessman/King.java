package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

public class King extends Chessman {

	public King(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(Chessman[] chessmans, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmans) {
			if (!chessman.equals(this) && Math.abs(chessman.getLocation().getX() - this.getLocation().getX()) < 2
					&& Math.abs(chessman.getLocation().getY() - this.getLocation().getY()) < 2) {
				result.add(chessman);
			}
		}
		return result;
	}

}
