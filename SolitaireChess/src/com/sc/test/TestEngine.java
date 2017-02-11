package com.sc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.sc.engine.State;
import com.sc.main.chessman.Bishop;
import com.sc.main.chessman.Chessman;
import com.sc.main.chessman.King;
import com.sc.main.chessman.Knight;
import com.sc.main.chessman.Location;
import com.sc.main.chessman.Pawn;
import com.sc.main.chessman.Rook;

public class TestEngine {

	@Test
	public void test_State_getPossibleVictims_Rook() {
		Rook rook = new Rook(2, 2);
		State state = new State(new Bishop(2, 3), rook, new Pawn(1, 2), new Knight(2, 1), new King(3, 3));

		List<Chessman> possibleVictims = state.getPossibleVictims(rook);
		assertEquals(3, possibleVictims.size());

		assertEquals(Bishop.class, possibleVictims.get(0).getClass());
		assertEquals(new Location(2, 3), possibleVictims.get(0).getLocation());

		assertEquals(Pawn.class, possibleVictims.get(1).getClass());
		assertEquals(new Location(1, 2), possibleVictims.get(1).getLocation());

		assertEquals(Knight.class, possibleVictims.get(2).getClass());
		assertEquals(new Location(2, 1), possibleVictims.get(2).getLocation());
	}

}
