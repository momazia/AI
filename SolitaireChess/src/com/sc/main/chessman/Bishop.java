package com.sc.main.chessman;

import java.util.List;

public class Bishop extends Chessman {

	public Bishop(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(Chessman[] chessmans, int boardSize) {
		return crossMovement(chessmans, boardSize);
	}

}
