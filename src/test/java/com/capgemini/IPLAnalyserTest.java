package com.capgemini;

import org.junit.*;

public class IPLAnalyserTest {
	public final String mostRunsCSVFile = "./MostRuns.csv";
	public final String mostWktsCSVFile = "./MostRuns.csv";

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndReturnEntries() {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		int noOfEntries = 0;
		try {
			noOfEntries = iplAnalyser.loadMostRunsCSV(mostRunsCSVFile);
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(101, noOfEntries);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndReturnEntries() {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		int noOfEntries = 0;
		try {
			noOfEntries = iplAnalyser.loadMostWktsCSV(mostWktsCSVFile);
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertEquals(101, noOfEntries);
	}
}
