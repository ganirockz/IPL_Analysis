package com.capgemini;

import com.opencsv.bean.CsvBindByName;

public class MostWkts {
	// POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w
	@CsvBindByName(column = "POS")
	public String pos;
	@CsvBindByName(column = "PLAYER")
	public String player;
	@CsvBindByName(column = "Mat")
	public String matches;
	@CsvBindByName(column = "Inns")
	public String innings;
	@CsvBindByName(column = "Ov")
	public String overs;
	@CsvBindByName(column = "Runs")
	public String runs;
	@CsvBindByName(column = "Wkts")
	public String wickets;
	@CsvBindByName(column = "BBI")
	public String bbi;
	@CsvBindByName(column = "Avg")
	private String average;
	@CsvBindByName(column = "Econ")
	private String economy;
	@CsvBindByName(column = "SR")
	private String strikeRate;
	@CsvBindByName(column = "4w")
	public String fourWickets;
	@CsvBindByName(column = "5w")
	public String fiveWickets;

	public double getAverage() {
		if (this.average.equals("-")) {
			return 0;
		} else {
			return Double.parseDouble(average);
		}
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public double getStrikeRate() {
		if (this.strikeRate.equals("-")) {
			return 0;
		} else {
			return Double.parseDouble(strikeRate);
		}
	}

	public double getEconomy() {
		if (this.economy.equals("-")) {
			return 0;
		} else {
			return Double.parseDouble(economy);
		}
	}
}
