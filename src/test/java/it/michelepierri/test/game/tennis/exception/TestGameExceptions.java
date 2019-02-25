package it.michelepierri.test.game.tennis.exception;

import org.junit.Before;
import org.junit.Test;

import it.michelepierri.game.tennis.event.impl.SingularMatchImpl;
import it.michelepierri.game.tennis.rule.impl.SingularMatchRuleImpl;

public class TestGameExceptions {

	SingularMatchImpl match;
	SingularMatchRuleImpl referree;

	@Before
	public void setUp() throws Exception {
		this.match = new SingularMatchImpl("Paul", "John");
		this.referree = new SingularMatchRuleImpl();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIllegalScore() {
		match.setScore(-1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIllegalScore2() {
		match.setScore(-1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetIllegalScore3() {
		match.setScore(0, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullMatch() {
		referree.getMatchScore(null);
	}
}
