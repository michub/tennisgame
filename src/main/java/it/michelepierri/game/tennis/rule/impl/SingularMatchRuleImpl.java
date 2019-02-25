package it.michelepierri.game.tennis.rule.impl;

import org.apache.log4j.Logger;

import it.michelepierri.game.tennis.enumerations.ScoreEnum;
import it.michelepierri.game.tennis.event.SingularMatch;
import it.michelepierri.game.tennis.rule.SingularMatchRule;

public class SingularMatchRuleImpl implements SingularMatchRule {

	static Logger log = Logger.getLogger(SingularMatchRuleImpl.class);

	public String getMatchScore(SingularMatch match) {
		if(match == null)
			throw new IllegalArgumentException("Match must not be null");
		
		int s1 = match.getScorePlayerOne();
		int s2 = match.getScorePlayerTwo();

		if (isPlayerOneWinner(s1, s2))
			return ScoreEnum.WIN.toString().replaceAll("%s", match.getPlayerOneName());

		else if (isPlayerTwoWinner(s1, s2))
			return ScoreEnum.WIN.toString().replaceAll("%s", match.getPlayerTwoName());

		else if (hasPlayerOneAdvantage(s1, s2))
			return ScoreEnum.ADVANTAGE.toString().replaceAll("%s", match.getPlayerOneName());

		else if (hasPlayerTwoAdvantage(s1, s2))
			return ScoreEnum.ADVANTAGE.toString().replaceAll("%s", match.getPlayerTwoName());

		else if (isDeuce(s1, s2))
			return ScoreEnum.DEUCE.toString();

		ScoreEnum resultP1 = ScoreEnum.findByKey(s1);
		ScoreEnum resultP2 = ScoreEnum.findByKey(s2);
			
		return resultP1 + ", " + resultP2;
	}

	private boolean isDeuce(int s1, int s2) {
		if (s1 >= 3 && s2 >= 3 && (s1 == s2))
			return true;
		return false;
	}

	private boolean isPlayerOneWinner(int s1, int s2) {
		if (s1 > 3 && (s1 - s2 >= 2))
			return true;
		return false;
	}

	private boolean isPlayerTwoWinner(int s1, int s2) {
		if (s2 > 3 && (s2 - s1 >= 2))
			return true;
		return false;
	}

	private boolean hasPlayerOneAdvantage(int s1, int s2) {
		if (s1 > s2 && (s1 >= 3 && s2 >= 3))
			return true;
		return false;
	}

	private boolean hasPlayerTwoAdvantage(int s1, int s2) {
		if (s2 > s1 && (s1 >= 3 && s2 >= 3))
			return true;
		return false;
	}

}
