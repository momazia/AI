package com.sc.main.chessman;

import java.util.List;

public class Bishop extends Chessman {

	public Bishop() {
		super();
	}

	public Bishop(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize) {
		return crossMovement(chessmen, boardSize);
	}

}
