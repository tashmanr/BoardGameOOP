package model.players;

import model.Game;
import model.Tuple;
import java.util.ArrayList;

/**
  * This class represents a player of the game.
  */
public abstract class Player {
	/**
	 * Updates the game state to take a move for the current player.
	 * @param game	the game to update.
	 */
	public abstract ArrayList<Tuple<Integer,Integer>> makeMove(Game game);

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public abstract String getPlayerName();
}
