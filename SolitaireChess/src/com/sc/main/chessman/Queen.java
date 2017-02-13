package com.sc.main.chessman;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Chessman {

	public Queen(int x, int y) {
		super(x, y);
	}

	@Override
	public List<Chessman> getPossibleVictims(Chessman[] chessmans, int boardSize) {
		List<Chessman> result = new ArrayList<>();
		result.addAll(crossMovement(chessmans, boardSize));
		result.addAll(plusMovement(chessmans, boardSize));
		return result;
	}

}
