package it.michelepierri.game.tennis.enumerations;

import java.util.HashMap;
import java.util.Map;

public enum ScoreEnum {
	ZERO("0","love"),
	ONE("1","fifteen"),
	TWO("2", "thirty"),
	THREE("3","forty"),
	ADVANTAGE("advantage", "PLAYER %s advantage"),
	DEUCE("deuce", "deuce"),
	WIN("win", "PLAYER %s win");

	
	private String id;
	private String description;
	private static final Map<String,ScoreEnum> map;
    
	ScoreEnum(String id, String description) {
		this.id = id;
		this.description= description;
	}
    
    static {
        map = new HashMap<String,ScoreEnum>();
        for (ScoreEnum v : ScoreEnum.values()) {
            map.put(v.id, v);
        }
    }
    
    public static ScoreEnum findByKey(String result) {
        return map.get(result);
    }
    
    public static ScoreEnum findByKey(int result) {
        return map.get(String.valueOf(result));
    }
    
    @Override
    public String toString() {
    	return this.description;
    }
}
