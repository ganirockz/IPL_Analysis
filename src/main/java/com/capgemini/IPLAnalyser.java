package com.capgemini;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBeanBuilder;

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

	public int loadMostWktsCSV(String path) throws IncorrectCSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			ICSVBuilder icsvBuilder = CSVBuildFactory.createCSVBuilder();
			wktsList = icsvBuilder.getCSVFileList(reader, MostWkts.class);
			return wktsList.size();
		} catch (IOException e) {
			throw new IncorrectCSVException("The file is not correct");
		}
	}

	public String sortAccordingToBattingAverage() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		return toJson(runsList);
	}

	private <E> void reverseSort(List<E> list, Comparator<E> censusComparator) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				E census1 = list.get(j);
				E census2 = list.get(j + 1);
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
		return toJson(runsList);
	}

	public String sortAccordingToMostSixesAndFours() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.sixes + ipl.fours);
		this.reverseSort(runsList, censusComparator);
		return toJson(runsList);
	}

	public String sortAccordingToMostSixesAndFoursAndBestStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.sixes + ipl.fours);
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		return toJson(runsList);
	}

	public String sortAccordingToBestAverageAndBestStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.getAvg());
		this.reverseSort(runsList, censusComparator);
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		return toJson(runsList);
	}

	public String sortAccordingToMostRunsScoredAndBestStrikeRate() throws IncorrectCSVException {
		if (runsList.size() == 0) {
			throw new IncorrectCSVException("No IPL Data");
		}
		runsList.stream().sorted(Comparator.comparing(ipl -> ipl.SR));
		Comparator<MostRuns> censusComparator = Comparator.comparing(ipl -> ipl.Runs);
		this.reverseSort(runsList, censusComparator);
		return toJson(runsList);
	}

	public <E> String toJson(List<E> list) {
		String json = new Gson().toJson(list);
		return json;
	}

	public String sortAccordingToBowlingAverage() throws IncorrectCSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostWkts> censusComparator = Comparator.comparing(ipl -> ipl.getAverage());
		this.reverseSort(wktsList, censusComparator);
		return toJson(wktsList);
	}

	public String sortAccordingToBowlersStrikeRate() throws IncorrectCSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostWkts> censusComparator = Comparator.comparing(ipl -> ipl.getStrikeRate());
		this.reverseSort(wktsList, censusComparator);
		return toJson(wktsList);
	}

	public String sortAccordingToEconomy() throws IncorrectCSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostWkts> censusComparator = Comparator.comparing(ipl -> ipl.getEconomy());
		this.sort(wktsList, censusComparator);
		return toJson(wktsList);
	}

	private <E> void sort(List<E> list, Comparator<E> censusComparator) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				E census1 = list.get(j);
				E census2 = list.get(j + 1);
				if (censusComparator.compare(census1, census2) > 0) {
					list.set(j, census2);
					list.set(j + 1, census1);
				}
			}
		}
	}

	public String sortAccordingToStrikeRateAnd4w5w() throws IncorrectCSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostWkts> censusComparator = Comparator
				.comparing(ipl -> ipl.getFourWickets() + ipl.getFiveWickets());
		this.reverseSort(wktsList, censusComparator);
		wktsList.stream().sorted(Comparator.comparing(ipl -> ipl.getStrikeRate()));
		return toJson(wktsList);
	}

	public String sortAccordingToStrikeRateAndAverage() throws IncorrectCSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostWkts> censusComparator = Comparator.comparing(ipl -> ipl.getAverage());
		this.reverseSort(wktsList, censusComparator);
		wktsList.stream().sorted(Comparator.comparing(ipl -> ipl.getStrikeRate()));
		return toJson(wktsList);
	}

	public String sortAccordingToWicketsAndAverage() throws IncorrectCSVException {
		if (wktsList.size() == 0 || wktsList == null) {
			throw new IncorrectCSVException("No IPL Data");
		}
		Comparator<MostWkts> censusComparator = Comparator.comparing(ipl -> ipl.getWickets());
		this.reverseSort(wktsList, censusComparator);
		wktsList.stream().sorted(Comparator.comparing(ipl -> ipl.getAverage()));
		return toJson(wktsList);
	}
}
