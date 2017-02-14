package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Chessman {

	public Knight() {
		super();
	}

	public Knight(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		for (Chessman chessman : chessmen) {
			if (!this.equals(chessman)) {
				boolean leftRight = Math.abs(chessman.getLocation().getX() - getLocation().getX()) == 2
						&& Math.abs(chessman.getLocation().getY() - getLocation().getY()) == 1;
				boolean topDown = Math.abs(chessman.getLocation().getX() - getLocation().getX()) == 1
						&& Math.abs(chessman.getLocation().getY() - getLocation().getY()) == 2;
				if (leftRight || topDown) {
					result.add(chessman);
				}
			}
		}
		return result;
	}

}
