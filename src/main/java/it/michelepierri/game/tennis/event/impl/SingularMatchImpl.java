package it.michelepierri.game.tennis.event.impl;

import it.michelepierri.game.tennis.event.SingularMatch;
import it.michelepierri.game.tennis.figure.Player;

public class SingularMatchImpl implements SingularMatch {
	private Player pOne;
	private int scorePOne = 0;

	private Player pTwo;
	private int scorePTwo = 0;

	public SingularMatchImpl(Player pOne, Player pTwo) {
		super();
		this.pOne = pOne;
		this.scorePOne = 0;
		this.pTwo = pTwo;
		this.scorePTwo = 0;
	}

	public SingularMatchImpl(String playerOneName, String playerTwoName) {
		this.pOne = new Player(playerOneName);
		this.scorePOne = 0;
		this.pTwo = new Player(playerTwoName);
		this.scorePTwo = 0;
	}

	@Override
	public void addScorePlayerOne() {
		this.scorePOne++;
	}

	@Override
	public void addScorePlayerTwo() {
		this.scorePTwo++;
	}

	@Override
	public void setScore(int s1, int s2) {
		if (s1 < 0 || s2 < 0)
			throw new IllegalArgumentException("All the scores must be greather than 0");
		this.scorePOne = s1;
		this.scorePTwo = s2;
	}

	@Override
	public int getScorePlayerOne() {
		return this.scorePOne;
	}

	@Override
	public int getScorePlayerTwo() {
		return this.scorePTwo;
	}

	@Override
	public String getPlayerOneName() {
		return this.pOne.getName();
	}

	@Override
	public String getPlayerTwoName() {
		return this.pTwo.getName();
	}

}
