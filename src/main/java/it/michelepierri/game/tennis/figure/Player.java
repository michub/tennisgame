package it.michelepierri.game.tennis.figure;

public class Player {
	private String name;

	public Player(String playerTwoName) {
		this.name = playerTwoName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
