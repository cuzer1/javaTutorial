package com.cengiz.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadFileWriteConsole {

	private static Logger logger = LogManager.getLogger(ReadFileWriteConsole.class);

	public static void main(String[] args) {

		// Logger logger = Logger.getLogger(ReadFileWriteConsole.class);
		// BasicConfigurator.configure();
		// logger.info("This is my first log4j's statement");

		logger.info("First Info message...\n");

		try (FileReader fis = new FileReader("input/dummyData.csv"); BufferedReader br = new BufferedReader(fis)) {

			// skip headers
			br.readLine();

			String line;

			while ((line = br.readLine()) != null) {
				String[] lr = line.split(",");

				System.out.println("id: " + lr[0]);
				System.out.println("name: " + lr[1]);
				System.out.println("email: " + lr[2]);
				System.out.println("date: " + lr[3]);
				System.out.println();
				logger.debug("tamir...\n");

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		logger.error("hata...\n");

	}

}
