package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Chessman {

	public Queen() {
		super();
	}

	public Queen(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(List<Chessman> chessmen, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		result.addAll(crossMovement(chessmen, boardSize));
		result.addAll(plusMovement(chessmen, boardSize));
		return result;
	}

}
