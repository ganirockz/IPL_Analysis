package com.capgemini;

import org.junit.*;

import com.google.gson.Gson;

public class IPLAnalyserTest {
	public final String mostRunsCSVFile = "./MostRuns.csv";
	public final String mostWktsCSVFile = "./MostWkts.csv";
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

		Assert.assertEquals(99, MostWktsCSVEntries);
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
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("Andre Russell", censusCsv[0].Player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToBestBattingAverageAndBestStrikeRates() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToBestAverageAndBestStrikeRate();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("MS Dhoni", censusCsv[0].Player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToMostRunsScoredAndBestStrikeRates() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToMostRunsScoredAndBestStrikeRate();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("David Warner", censusCsv[0].Player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingBowlingAverage() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToBowlingAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostWkts[] censusCsv = new Gson().fromJson(sortedData, MostWkts[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingToStrikeRates() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToBowlersStrikeRate();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostWkts[] censusCsv = new Gson().fromJson(sortedData, MostWkts[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingToEconomy() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToEconomy();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostWkts[] censusCsv = new Gson().fromJson(sortedData, MostWkts[].class);
		Assert.assertEquals("Shivam Dube", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingToBestStrikeRateAnd4w5w() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToStrikeRateAnd4w5w();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostWkts[] censusCsv = new Gson().fromJson(sortedData, MostWkts[].class);
		Assert.assertEquals("Imran Tahir", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingToStrikeRateAndAverage() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToStrikeRateAndAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostWkts[] censusCsv = new Gson().fromJson(sortedData, MostWkts[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortAccordingToWicketsAndAverage() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToWicketsAndAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostWkts[] censusCsv = new Gson().fromJson(sortedData, MostWkts[].class);
		Assert.assertEquals("Imran Tahir", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortBestBattingAvgAndBowlingAvg() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToBattingAndBowlingAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		RunsAndWkts[] censusCsv = new Gson().fromJson(sortedData, RunsAndWkts[].class);
		Assert.assertEquals("Marcus Stoinis", censusCsv[0].player);
	}

	@Test
	public void givenMostWktsCSVFile_ShouldLoadAndSortBasedOnMostRunsAndWickets() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToMostRunsAndWickets();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		RunsAndWkts[] censusCsv = new Gson().fromJson(sortedData, RunsAndWkts[].class);
		Assert.assertEquals("Hardik Pandya", censusCsv[0].player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToMost100sAndBestAverages() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToMost100sAndBestAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("David Warner", censusCsv[0].Player);
	}

	@Test
	public void givenMostRunsCSVFile_ShouldLoadAndSortAccordingToZero100sAnd50sAndBestAverages() {
		String sortedData = null;
		try {
			sortedData = iplAnalyser.sortAccordingToZero100sAnd50sAndBestAverage();
		} catch (IncorrectCSVException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sortedData);
		MostRuns[] censusCsv = new Gson().fromJson(sortedData, MostRuns[].class);
		Assert.assertEquals("Marcus Stoinis", censusCsv[0].Player);
	}
}
