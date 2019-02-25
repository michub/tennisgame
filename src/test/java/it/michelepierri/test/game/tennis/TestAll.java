package it.michelepierri.test.game.tennis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import it.michelepierri.test.game.tennis.exception.TestGameExceptions;
import it.michelepierri.test.game.tennis.match.TestMatch;

@RunWith(Suite.class)
@SuiteClasses({ TestMatch.class, TestGameExceptions.class })
public class TestAll {

}
