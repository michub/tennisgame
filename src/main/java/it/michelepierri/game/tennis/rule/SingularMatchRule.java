package it.michelepierri.game.tennis.rule;

import it.michelepierri.game.tennis.event.SingularMatch;

public interface SingularMatchRule {

	/**
	 * Return match score in String format
	 * @param match{@link SingularMatch}
	 * @return{@link String}
	 */
	public String getMatchScore(SingularMatch match);
}
