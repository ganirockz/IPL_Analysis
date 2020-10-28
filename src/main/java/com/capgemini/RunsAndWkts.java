package com.capgemini;

public class RunsAndWkts {
	public int runs;
	public int wickets;

	public RunsAndWkts(String player, double battingAvg, double bowlingAvg, int runs, int wickets) {
		this.player = player;
		this.battingAvg = battingAvg;
		this.bowlingAvg = bowlingAvg;
		this.runs = runs;
		this.wickets = wickets;
	}

	public String player;
	public double battingAvg;
	public double bowlingAvg;
}
