package com.cengiz.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAssignObject {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String currDate = dtf.format(now);

		try (FileReader fr = new FileReader("/Users/cengizuzer/git/javaTutorial/Examples/input/dummyData.csv");
				BufferedReader br = new BufferedReader(fr);) {

			// skip headers
			String[] hdr = br.readLine().split(",");

			String line;
			
			List<Record> records = new ArrayList<Record>();

			while ((line = br.readLine()) != null) {
				String[] lr = line.split(",");
				Record r = new Record(Long.parseLong(lr[0]), lr[1], lr[2], lr[3]);
				records.add(r);
			}
			
			for (Record rec : records) {
				System.out.println(rec);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
