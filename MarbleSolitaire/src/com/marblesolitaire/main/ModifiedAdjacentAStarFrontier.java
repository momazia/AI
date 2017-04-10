package com.marblesolitaire.main;

/**
 * Modified Adjacent A* frontier is the same as Adjacent A*, except that it gives higher score to those nodes at the lower levels in the tree since we
 * know the answer is at the leaves.
 * 
 * @author Mahdi Ziaee
 *
 */
public class ModifiedAdjacentAStarFrontier extends AdjacentAStarFrontier {

	/**
	 * Calculates the current state's score by adding the heuristic of the state to maximum possible score (root state score) * path of getting to
	 * this node
	 * 
	 * @param marbleSolitaireState
	 * @param maxHeuristicScore
	 * @return
	 */
	@Override
	protected int calculateStateScore(int heuristicScore, int path) {
		return heuristicScore + path * maxHeuristicScore;
	}

}
