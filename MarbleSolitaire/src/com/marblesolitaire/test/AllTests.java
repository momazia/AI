package com.marblesolitaire.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEngine.class, TestMarbleSolitaireState.class, TestAdjacentAStarFrontier.class })
public class AllTests {

}
