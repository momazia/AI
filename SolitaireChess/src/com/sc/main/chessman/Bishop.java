package com.sc.main.chessman;

public class Bishop extends Chessman {

	public Bishop(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canTakeDown(Chessman boardChessman) {
		// Location localLocation = getLocation();
		// Location boardChessmanLocation = boardChessman.getLocation();
		return false;
	}

}
