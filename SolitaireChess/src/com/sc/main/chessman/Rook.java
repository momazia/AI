package com.sc.main.chessman;

import java.util.List;

public class Rook extends Chessman {

	public Rook(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(Chessman[] chessmans, int boardSize) {
		return plusMovement(chessmans, boardSize);
	}

}
