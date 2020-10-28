package com.capgemini;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

public class IPLAnalyser {
	List<MostRuns> runsList = null;
	List<MostWkts> wktsList = null;

	public int loadMostRunsCSV(String filePath) throws IncorrectCSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder icsvBuilder = CSVBuildFactory.createCSVBuilder();
			runsList = icsvBuilder.getCSVFileList(reader, MostRuns.class);
			return runsList.size();
		} catch (Exception e) {
			throw new IncorrectCSVException("The file is not correct");
		}
	}

	public int loadMostWktsCSV(String filePath) throws IncorrectCSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder icsvBuilder = CSVBuildFactory.createCSVBuilder();
			wktsList = icsvBuilder.getCSVFileList(reader, MostWkts.class);
			return wktsList.size();
		} catch (Exception e) {
			throw new IncorrectCSVException("The file is not correct");
		}
	}

	public String sortAccordingToBattingAverage() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		return MostRunstoJson();
	}

	private void reverseSort(List<MostRuns> list, Comparator<MostRuns> censusComparator) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				MostRuns census1 = list.get(j);
				MostRuns census2 = list.get(j + 1);
				if (censusComparator.compare(census1, census2) < 0) {
					list.set(j, census2);
					list.set(j + 1, census1);
				}
			}
		}
	}

	public String sortAccordingToStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.SR);
		this.reverseSort(runsList, censusComparator);
		return MostRunstoJson();
	}

	public String sortAccordingToMostSixesAndFours() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.sixes + ipl.fours);
		this.reverseSort(runsList, censusComparator);
		return MostRunstoJson();
	}

	public String sortAccordingToMostSixesAndFoursAndBestStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.sixes + ipl.fours);
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		return MostRunstoJson();
	}

	public String sortAccordingToBestAverageAndBestStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		return MostRunstoJson();
	}

	public String sortAccordingToMostRunsScoredAndBestStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.Runs);
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		return MostRunstoJson();
	}
	
	public String MostRunstoJson() {
		String json = new Gson().toJson(runsList);
		return json;
	}

}
