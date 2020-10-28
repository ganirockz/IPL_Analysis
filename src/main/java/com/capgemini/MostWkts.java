package com.capgemini;

import com.opencsv.bean.CsvBindByName;

public class MostWkts {
	// POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w
	@CsvBindByName
	public int POS;
	@CsvBindByName
	public String PLAYER;
	@CsvBindByName
	public int Math;
	@CsvBindByName
	public int Inns;
	@CsvBindByName
	public int Ov, Runs, Wkts, BBI;
	@CsvBindByName
	public String Avg;
	@CsvBindByName
	public String Econ;
	@CsvBindByName
	public String SR;
	@CsvBindByName
	public int fourWickets;
	@CsvBindByName
	public int fiveWickets;
}
