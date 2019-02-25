package it.michelepierri.game.tennis.runner;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunTennisGame implements CommandLineRunner {
	 
	private static Logger log = Logger.getLogger(RunTennisGame.class);
	 
	    public static void main(String[] args) {
	    	log.info("Starting the game");
	        SpringApplication.run(RunTennisGame.class, args);
	        log.info("Closing the game");
	    }
	  
	    @Override
	    public void run(String... args) {
	    	log.info("The game is ready");
	    	// TODO implements something with Tennis Game
	    }
	}