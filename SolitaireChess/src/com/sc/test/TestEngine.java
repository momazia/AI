package com.sc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.sc.main.chessman.Bishop;
import com.sc.main.chessman.Chessman;
import com.sc.main.chessman.Location;
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
	public void test_getPossibleVictims0() {
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
	public void test_getPossibleVictims1() {
		Rook rook = new Rook(2, 2);
		Chessman[] boardChessmans = new Chessman[] { new Bishop(3, 3), new Bishop(1, 1), rook, new Bishop(3, 1), new Bishop(1, 3) };

		List<Chessman> possibleVictims = rook.getPossibleVictims(boardChessmans, 4);
		assertEquals(0, possibleVictims.size());
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

}
