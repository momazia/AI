package com.sc.main.chessman;

public class Rook extends Chessman {


	public Rook(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canTakeDown(Chessman boardChessman) {
		Location localLocation = getLocation();
		Location boardChessmanLocation = boardChessman.getLocation();
		return localLocation.getX() == boardChessmanLocation.getX()
				|| localLocation.getY() == boardChessmanLocation.getY();
	}

}
