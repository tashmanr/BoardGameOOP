package model.players;

import model.Tuple;
import model.boards.Board;

import java.util.ArrayList;

/**
  * This class represents a player of the game.
  */
public abstract class Player {
	/**
	 * Updates the game state to take a move for the current player.
	 * @param board	the board to update.
	 */
	public abstract ArrayList<Tuple<Integer,Integer>> makeMove(Board board);

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public abstract String getPlayerName();
}
