package it.michelepierri.game.tennis.event;

public interface SingularMatch extends Match {

	/**
	 * Add one point to player one
	 */
	public void addScorePlayerOne();

	/**
	 * Add one point to second player
	 */
	public void addScorePlayerTwo();

	/**
	 * Get player one score 
	 * @return player one score
	 */
	public int getScorePlayerOne();

	/**
	 * Get player two score
	 * @return player two score
	 */
	public int getScorePlayerTwo();

	/**
	 * Set match score
	 * @param s1 integer score of player one
	 * @param s2 integer score of player two s2
	 */
	public void setScore(int s1, int s2);

	/**
	 * Get player one name
	 * @return{@link String}
	 */
	public String getPlayerOneName();
	
	/**
	 * Get player two name
	 * @return{@link String}
	 */
	public String getPlayerTwoName();
}
