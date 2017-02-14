package com.sc.main.chessman;

import java.util.List;

/**
 * This class represents a Rook chessman. It can move in plus shape.
 * 
 * @author Mahdi Ziaee
 *
 */
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
