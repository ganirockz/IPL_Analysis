package com.capgemini;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLAnalyser {

	public int loadMostRunsCSV(String filePath) throws IncorrectCSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder icsvBuilder = CSVBuildFactory.createCSVBuilder();
			List<MostRuns> list = null;
			list = icsvBuilder.getCSVFileList(reader, MostRuns.class);
			return list.size();
		} catch (Exception e) {
			throw new IncorrectCSVException("The file is not correct");
		}
	}

	public int loadMostWktsCSV(String filePath) throws IncorrectCSVException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			ICSVBuilder icsvBuilder = CSVBuildFactory.createCSVBuilder();
			List<MostWkts> list = null;
			list = icsvBuilder.getCSVFileList(reader, MostWkts.class);
			return list.size();
		} catch (Exception e) {
			throw new IncorrectCSVException("The file is not correct");
		}
	}

}
