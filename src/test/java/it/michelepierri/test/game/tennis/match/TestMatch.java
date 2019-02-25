package it.michelepierri.test.game.tennis.match;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.michelepierri.game.tennis.enumerations.ScoreEnum;
import it.michelepierri.game.tennis.event.impl.SingularMatchImpl;
import it.michelepierri.game.tennis.figure.Player;
import it.michelepierri.game.tennis.rule.impl.SingularMatchRuleImpl;

public class TestMatch {

	SingularMatchImpl match;
	SingularMatchRuleImpl referree;

	@Before
	public void setUp() throws Exception {
		this.match = new SingularMatchImpl("Paul", "John");
		this.referree = new SingularMatchRuleImpl();
	}

	@Test
	public void testNewGameLoveScore() {
		assertEquals(referree.getMatchScore(match), ScoreEnum.ZERO.toString() + ", " + ScoreEnum.ZERO.toString());
	}

	@Test
	public void testPTwoScoreFirstFifteenScore() {
		match.setScore(0, 1);
		assertEquals(referree.getMatchScore(match), ScoreEnum.ZERO.toString() + ", " + ScoreEnum.ONE.toString());
	}

	@Test
	public void testPOneScoreFirstFifteenScore() {
		match.setScore(1, 0);
		assertEquals(referree.getMatchScore(match), ScoreEnum.ONE.toString() + ", " + ScoreEnum.ZERO.toString());
	}

	@Test
	public void testAllScoresOnePointFifteenScore() {
		match.setScore(1, 1);
		assertEquals(referree.getMatchScore(match), ScoreEnum.ONE.toString() + ", " + ScoreEnum.ONE.toString());
	}

	@Test
	public void testPOneScoreTwiceThirtyScore() {
		match.setScore(2, 1);
		assertEquals(referree.getMatchScore(match), ScoreEnum.TWO.toString() + ", " + ScoreEnum.ONE.toString());
	}
	
	@Test
	public void testPOnePTwoScoreTwiceScore() {
		match.setScore(2, 2);
		assertEquals(referree.getMatchScore(match), ScoreEnum.TWO.toString() + ", " + ScoreEnum.TWO.toString());
	}

	@Test
	public void testPTwoScoreThreeTimesFourtyScore() {
		match.setScore(2, 3);
		assertEquals(referree.getMatchScore(match), ScoreEnum.TWO.toString() + ", " + ScoreEnum.THREE.toString());
	}

	@Test
	public void testDeuceScore() {
		match.setScore(3, 3);
		assertEquals(referree.getMatchScore(match), ScoreEnum.DEUCE.toString());
	}

	@Test
	public void testPOneScoresFourTimesAdvantage() throws Exception {
		match.setScore(4, 3);
		assertEquals(referree.getMatchScore(match),
				ScoreEnum.ADVANTAGE.toString().replaceAll("%s", match.getPlayerOneName()));
	}

	@Test
	public void testPTwoScoresFourTimesAdvantage() throws Exception {
		match.setScore(3, 4);
		assertEquals(referree.getMatchScore(match),
				ScoreEnum.ADVANTAGE.toString().replaceAll("%s", match.getPlayerTwoName()));
	}

	@Test
	public void testDeuceWhenScoresMoreOfFourPoints() throws Exception {
		match.setScore(4, 4);
		assertEquals(referree.getMatchScore(match), ScoreEnum.DEUCE.toString());
	}

	@Test
	public void testPOneWin() throws Exception {
		match.setScore(4, 2);
		assertEquals(referree.getMatchScore(match),
				ScoreEnum.WIN.toString().replaceAll("%s", match.getPlayerOneName()));
	}

	@Test
	public void testPTwoWin() throws Exception {
		match.setScore(0, 4);
		assertEquals(referree.getMatchScore(match),
				ScoreEnum.WIN.toString().replaceAll("%s", match.getPlayerTwoName()));
	}

	@Test
	public void testMatchParameterConstructor() {
		Player p1 = new Player("Paul");
		Player p2 = new Player("John");
		SingularMatchImpl secondMatch = new SingularMatchImpl(p1, p2);
		assertNotNull(secondMatch);
	}

	@Test
	public void testAddScorePlayerOne() {
		match.setScore(0, 0);
		match.addScorePlayerOne();
		assertEquals(1, match.getScorePlayerOne());
	}

	@Test
	public void testAddScorePlayerTwo() {
		match.setScore(0, 0);
		match.addScorePlayerTwo();
		assertEquals(1, match.getScorePlayerTwo());
	}

	@Test
	public void testChangePlayerName() {
		Player p1 = new Player("Paul");
		p1.setName("Michele");
		assertEquals("Michele", p1.getName());
	}
	
	@Test
	public void testEnumFindByIntKey() {
		assertEquals(ScoreEnum.findByKey(0), ScoreEnum.ZERO);
	}

	@Test
	public void testEnumFindByStringKey() {
		assertEquals(ScoreEnum.findByKey("win"), ScoreEnum.WIN);
	}
}