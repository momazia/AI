package com.sc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.sc.main.chessman.Bishop;
import com.sc.main.chessman.Chessman;
import com.sc.main.chessman.King;
import com.sc.main.chessman.Knight;
import com.sc.main.chessman.Location;
import com.sc.main.chessman.Pawn;
import com.sc.main.chessman.Queen;
import com.sc.main.chessman.Rook;

public class TestEngine {

	@Test
	public void test_getPossibleVictims_right0() {
		Rook rook = new Rook(4, 1);
		Chessman[] boardChessmans = new Chessman[] { new Rook(4, 4), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman right = rook.right(boardChessmans, 4);
		assertNull(right);
	}

	@Test
	public void test_getPossibleVictims_right1() {
		Rook rook = new Rook(1, 1);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 4), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman right = rook.right(boardChessmans, 4);
		assertEquals(Bishop.class, right.getClass());
		assertEquals(new Location(2, 1), right.getLocation());
	}

	@Test
	public void test_getPossibleVictims_right2() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Rook(4, 2), new Bishop(3, 3), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 1),
				new Rook(1, 1) };

		Chessman right = rook.right(boardChessmans, 4);
		assertEquals(Rook.class, right.getClass());
		assertEquals(new Location(4, 2), right.getLocation());
	}

	@Test
	public void test_getPossibleVictims_right3() {
		Rook rook = new Rook(1, 1);
		Chessman[] boardChessmans = new Chessman[] { rook, new Bishop(4, 4), new Bishop(2, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman up = rook.up(boardChessmans, 4);
		assertNull(up);
	}

	@Test
	public void test_getPossibleVictims_Up0() {
		Rook rook = new Rook(4, 1);
		Chessman[] boardChessmans = new Chessman[] { new Rook(4, 4), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman up = rook.up(boardChessmans, 4);
		assertEquals(Rook.class, up.getClass());
		assertEquals(new Location(4, 4), up.getLocation());
	}

	@Test
	public void test_getPossibleVictims_Up1() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(2, 4), new Bishop(2, 3), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3),
				new Rook(3, 2) };

		Chessman up = rook.up(boardChessmans, 4);
		assertEquals(Bishop.class, up.getClass());
		assertEquals(new Location(2, 3), up.getLocation());
	}

	@Test
	public void test_getPossibleVictims_Up2() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman up = rook.up(boardChessmans, 4);
		assertNull(up);
	}

	@Test
	public void test_getPossibleVictims_Down0() {
		Rook rook = new Rook(1, 4);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 1), rook, new Bishop(2, 2), new Bishop(4, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman down = rook.down(boardChessmans, 4);
		assertEquals(Rook.class, down.getClass());
		assertEquals(new Location(1, 1), down.getLocation());
	}

	@Test
	public void test_getPossibleVictims_Down1() {
		Rook rook = new Rook(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Rook(2, 2), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3), new Rook(3, 2) };

		Chessman down = rook.down(boardChessmans, 4);
		assertEquals(Rook.class, down.getClass());
		assertEquals(new Location(2, 2), down.getLocation());
	}

	@Test
	public void test_getPossibleVictims_Down2() {
		Rook rook = new Rook(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 2), rook, new Bishop(1, 2), new Bishop(2, 4), new Rook(3, 3), new Rook(3, 2) };

		Chessman down = rook.down(boardChessmans, 4);
		assertNull(down);
	}

	@Test
	public void test_getPossibleVictimsRook0() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(2, 4), new Bishop(2, 3), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(3, 3),
				new Rook(3, 2) };

		List<Chessman> possibleVictims = rook.getPossibleVictims(boardChessmans, 4);
		assertEquals(4, possibleVictims.size());

		assertEquals(Bishop.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(2, 3), possibleVictims.get(0).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(2, 1), possibleVictims.get(1).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(2).getClass());
		assertEquals(new Location(1, 2), possibleVictims.get(2).getLocation());

		assertEquals(Rook.class, possibleVictims.get(3).getClass());
		assertEquals(new Location(3, 2), possibleVictims.get(3).getLocation());
	}

	@Test
	public void test_getPossibleVictimsRook1() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(3, 3), new Bishop(1, 1), rook, new Bishop(3, 1), new Bishop(1, 3) };

		List<Chessman> possibleVictims = rook.getPossibleVictims(boardChessmans, 4);
		assertEquals(0, possibleVictims.size());
	}

	@Test
	public void test_getPossibleVictimsBishop0() {
		Bishop bishop = new Bishop(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(1, 2), new Bishop(2, 2), bishop, new Bishop(4, 1), new Bishop(3, 2), new Rook(1, 4),
				new Rook(3, 4) };

		List<Chessman> possibleVictims = bishop.getPossibleVictims(boardChessmans, 4);
		assertEquals(4, possibleVictims.size());

		assertEquals(Rook.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(3, 4), possibleVictims.get(0).getLocation());

		assertEquals(Rook.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(1, 4), possibleVictims.get(1).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(2).getClass());
		assertEquals(new Location(3, 2), possibleVictims.get(2).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(3).getClass());
		assertEquals(new Location(1, 2), possibleVictims.get(3).getLocation());
	}

	@Test
	public void test_getPossibleVictimsBishop1() {
		Bishop bishop = new Bishop(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(2, 4), new Bishop(1, 2), bishop, new Bishop(4, 1), new Bishop(4, 2) };

		List<Chessman> possibleVictims = bishop.getPossibleVictims(boardChessmans, 4);
		assertEquals(0, possibleVictims.size());
	}

	@Test
	public void test_getPossibleVictimsQueen0() {
		Queen queen = new Queen(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(1, 2), new Bishop(2, 2), new Bishop(2, 1), queen, new Bishop(4, 1), new Queen(3, 2),
				new Bishop(1, 4), new Rook(4, 4) };

		List<Chessman> possibleVictims = queen.getPossibleVictims(boardChessmans, 4);
		assertEquals(4, possibleVictims.size());

		assertEquals(Bishop.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(1, 4), possibleVictims.get(0).getLocation());

		assertEquals(Queen.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(3, 2), possibleVictims.get(1).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(2).getClass());
		assertEquals(new Location(1, 2), possibleVictims.get(2).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(3).getClass());
		assertEquals(new Location(2, 2), possibleVictims.get(3).getLocation());

	}

	@Test
	public void test_getPossibleVictimsQueen1() {
		Queen queen = new Queen(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(4, 4), new Bishop(4, 2), queen, new Bishop(1, 1), new Bishop(3, 1) };

		List<Chessman> possibleVictims = queen.getPossibleVictims(boardChessmans, 4);
		assertEquals(0, possibleVictims.size());
	}

	@Test
	public void test_getPossibleVictimsPawn0() {
		Pawn pawn = new Pawn(3, 2);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(1, 4), new Bishop(2, 4), new Bishop(3, 4), pawn, new Bishop(3, 3), new Queen(1, 3),
				new Rook(2, 3), new Rook(4, 3), new Rook(1, 1), new Rook(2, 1) };

		List<Chessman> possibleVictims = pawn.getPossibleVictims(boardChessmans, 4);
		assertEquals(2, possibleVictims.size());

		assertEquals(Rook.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(2, 3), possibleVictims.get(0).getLocation());

		assertEquals(Rook.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(4, 3), possibleVictims.get(1).getLocation());
	}

	@Test
	public void test_getPossibleVictimsPawn1() {
		Pawn pawn = new Pawn(1, 4);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(2, 4), new Bishop(3, 4), pawn, new Bishop(3, 3), new Queen(1, 3), new Rook(2, 3),
				new Rook(4, 3), new Rook(1, 1), new Rook(2, 1) };

		List<Chessman> possibleVictims = pawn.getPossibleVictims(boardChessmans, 4);
		assertEquals(0, possibleVictims.size());
	}

	@Test
	public void test_getPossibleVictimsKnight0() {
		Knight knight = new Knight(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(4, 4), new Bishop(4, 2), new Bishop(1, 1), knight, new Queen(3, 1), new Queen(2, 1),
				new Rook(2, 4), new Rook(1, 4) };

		List<Chessman> possibleVictims = knight.getPossibleVictims(boardChessmans, 4);
		assertEquals(4, possibleVictims.size());

		assertEquals(Bishop.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(4, 4), possibleVictims.get(0).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(4, 2), possibleVictims.get(1).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(2).getClass());
		assertEquals(new Location(1, 1), possibleVictims.get(2).getLocation());

		assertEquals(Queen.class, possibleVictims.get(3).getClass());
		assertEquals(new Location(3, 1), possibleVictims.get(3).getLocation());
	}

	@Test
	public void test_getPossibleVictimsKnight1() {
		Knight knight = new Knight(4, 1);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(4, 4), new Bishop(4, 2), new Bishop(1, 1), knight, new Queen(3, 1), new Queen(2, 1),
				new Rook(2, 4), new Rook(1, 4) };

		List<Chessman> possibleVictims = knight.getPossibleVictims(boardChessmans, 4);
		assertEquals(0, possibleVictims.size());
	}

	@Test
	public void test_getPossibleVictimsKing0() {
		King king = new King(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(1, 4), new Bishop(2, 4), new Bishop(3, 4), king, new Bishop(4, 4), new Queen(1, 3),
				new Rook(3, 3), new Rook(4, 3), new Rook(1, 1), new Rook(2, 1) };

		List<Chessman> possibleVictims = king.getPossibleVictims(boardChessmans, 4);
		assertEquals(5, possibleVictims.size());

		assertEquals(Bishop.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(1, 4), possibleVictims.get(0).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(2, 4), possibleVictims.get(1).getLocation());

		assertEquals(Bishop.class, possibleVictims.get(2).getClass());
		assertEquals(new Location(3, 4), possibleVictims.get(2).getLocation());

		assertEquals(Queen.class, possibleVictims.get(3).getClass());
		assertEquals(new Location(1, 3), possibleVictims.get(3).getLocation());

		assertEquals(Rook.class, possibleVictims.get(4).getClass());
		assertEquals(new Location(3, 3), possibleVictims.get(4).getLocation());
	}

	@Test
	public void test_getPossibleVictimsKing1() {
		King king = new King(1, 4);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(2, 3), new Bishop(3, 2), king, new Bishop(1, 1), new Bishop(3, 4) };

		List<Chessman> possibleVictims = king.getPossibleVictims(boardChessmans, 4);
		assertEquals(1, possibleVictims.size());

		assertEquals(Bishop.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(2, 3), possibleVictims.get(0).getLocation());
	}

	@Test
	public void test_getPossibleVictims_UpRight0() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 1), rook, new Bishop(2, 2), new Bishop(4, 1), new Rook(3, 2) };

		Chessman upRight = rook.upRight(boardChessmans, 4);
		assertNull(upRight);
	}

	@Test
	public void test_getPossibleVictims_UpRight1() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Rook(3, 3), rook, new Bishop(1, 2), new Bishop(2, 1), new Rook(4, 4), new Rook(3, 2) };

		Chessman upRight = rook.upRight(boardChessmans, 4);
		assertEquals(Rook.class, upRight.getClass());
		assertEquals(new Location(3, 3), upRight.getLocation());
	}

	@Test
	public void test_getPossibleVictims_UpRight2() {
		Rook rook = new Rook(4, 1);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 2), rook, new Bishop(1, 2), new Bishop(2, 4), new Rook(3, 3), new Rook(3, 2) };

		Chessman upRight = rook.upRight(boardChessmans, 4);
		assertNull(upRight);
	}

	@Test
	public void test_getPossibleVictims_UpRight3() {
		Rook rook = new Rook(1, 4);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 2), rook, new Bishop(1, 2), new Bishop(2, 4), new Rook(3, 3), new Rook(3, 2) };

		Chessman upRight = rook.upRight(boardChessmans, 4);
		assertNull(upRight);
	}

	@Test
	public void test_getPossibleVictims_UpLeft0() {
		Bishop bishop = new Bishop(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 1), bishop, new Bishop(2, 3), new Bishop(4, 1), new Rook(3, 2) };

		Chessman upLeft = bishop.upLeft(boardChessmans, 4);
		assertNull(upLeft);
	}

	@Test
	public void test_getPossibleVictims_UpLeft1() {
		Bishop bishop = new Bishop(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 3), bishop, new Bishop(2, 3), new Bishop(4, 1), new Rook(3, 2) };

		Chessman upLeft = bishop.upLeft(boardChessmans, 4);
		assertEquals(Rook.class, upLeft.getClass());
		assertEquals(new Location(1, 3), upLeft.getLocation());
	}

	@Test
	public void test_getPossibleVictims_UpLeft2() {
		Bishop bishop = new Bishop(4, 1);
		Chessman[] boardChessmans = new Chessman[] { new Rook(2, 3), bishop, new Bishop(1, 4), new Bishop(2, 4), new Rook(3, 3) };

		Chessman upLeft = bishop.upLeft(boardChessmans, 4);
		assertEquals(Rook.class, upLeft.getClass());
		assertEquals(new Location(2, 3), upLeft.getLocation());
	}

	@Test
	public void test_getPossibleVictims_UpLeft3() {
		Bishop bishop = new Bishop(1, 4);
		Chessman[] boardChessmans = new Chessman[] { new Rook(2, 3), bishop, new Bishop(3, 4), new Bishop(2, 4), new Rook(3, 3) };

		Chessman upLeft = bishop.upLeft(boardChessmans, 4);
		assertNull(upLeft);
	}

	@Test
	public void test_getPossibleVictims_DownRight0() {
		Bishop bishop = new Bishop(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 1), bishop, new Bishop(2, 3), new Bishop(4, 1), new Rook(3, 2) };

		Chessman downRight = bishop.downRight(boardChessmans, 4);
		assertNull(downRight);
	}

	@Test
	public void test_getPossibleVictims_DownRight1() {
		Bishop bishop = new Bishop(2, 3);
		Chessman[] boardChessmans = new Chessman[] { new Rook(1, 3), bishop, new Bishop(2, 3), new Bishop(4, 1), new Rook(3, 2) };

		Chessman downRight = bishop.downRight(boardChessmans, 4);
		assertEquals(Rook.class, downRight.getClass());
		assertEquals(new Location(3, 2), downRight.getLocation());
	}

	@Test
	public void test_getPossibleVictims_DownRight2() {
		Bishop bishop = new Bishop(4, 1);
		Chessman[] boardChessmans = new Chessman[] { new Rook(2, 3), bishop, new Bishop(1, 4), new Bishop(2, 4), new Rook(3, 3) };

		Chessman downRight = bishop.downRight(boardChessmans, 4);
		assertNull(downRight);
	}

}
