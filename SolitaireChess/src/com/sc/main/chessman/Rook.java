package com.sc.main.chessman;

import java.util.List;

public class Rook extends Chessman {

	public Rook() {
		super();
	}

	public Rook(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize) {
		return plusMovement(chessmen, boardSize);
	}

}
