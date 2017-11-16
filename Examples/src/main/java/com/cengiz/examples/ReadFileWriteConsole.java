package com.cengiz.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileWriteConsole {

	public static void main(String[] args) {

		try (FileReader fis = new FileReader("input/dummyData.csv");
				BufferedReader br = new BufferedReader(fis)) {

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

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
