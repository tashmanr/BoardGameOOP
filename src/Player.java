/**
  * This class represents a player of the game.
  */
public abstract class Player {

	/**
	 * Updates the game state to take a move for the current player.
	 * @param game	the game to update.
	 */
	public abstract void makeMove(Game game);

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[isHuman=" + isHuman() + "]";
	}
}
