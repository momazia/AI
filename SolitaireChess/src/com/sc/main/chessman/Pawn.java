package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Chessman {

	public Pawn(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(Chessman[] chessmans, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmans) {
			if (!this.equals(chessman) && (Math.abs(chessman.getLocation().getX() - getLocation().getX()) == 1
					&& chessman.getLocation().getY() - getLocation().getY() == 1)) {
				result.add(chessman);
			}
		}
		return result;
	}

}
