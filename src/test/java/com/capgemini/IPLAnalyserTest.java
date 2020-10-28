package com.capgemini;

import org.junit.*;

import com.google.gson.Gson;

public class IPLAnalyserTest {
	public final String mostRunsCSVFile = "./MostRuns.csv";
	public final String mostWktsCSVFile = "./MostRuns.csv";
	int MostRunsCSVEntries = 0, MostWktsCSVEntries = 0;
	IPLAnalyser iplAnalyser = null;

	@Before
	public void setUp() {
		iplAnalyser = new IPLAnalyser();
		try {
			MostRunsCSVEntries = iplAnalyser.loadMostRunsCSV(mostRunsCSVFile);
			MostWktsCSVEntries = iplAnalyser.loadMostWktsCSV(mostWktsCSVFile);
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndReturnEntries() {
		Assert.assertEquals(101, MostRunsCSVEntries);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndReturnEntries() {

		Assert.assertEquals(101, MostWktsCSVEntries);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingBattingAverage() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToBattingAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("MS Dhoni", censusCsv[0].Player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToStrikeRate() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToStrikeRate();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("Ishant Sharma", censusCsv[0].Player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToMostSixes() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToMostSixesAndFours();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("Andre Russell", censusCsv[0].Player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToMost6sAnd4sAndBestStrikeRates() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToMostSixesAndFoursAndBestStrikeRate();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sortedData);
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("Andre Russell", censusCsv[0].Player);
	}
}
