package com.cengiz.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileWriteFileWithMoreField {

	public static void main(String[] args) {

		try (FileReader fr = new FileReader("/Users/cengizuzer/git/javaTutorial/Examples/input/dummyData.csv");
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("/Users/cengizuzer/git/javaTutorial/Examples/output/dummyDataOut.csv");
				BufferedWriter bw = new BufferedWriter(fw);

		) {

			// skip headers
			String[] hdr = br.readLine().split(",");

			for (String field : hdr) {
				bw.write(field);
				bw.write(",");
			}

			bw.write("fname,lname\n");

			String line;

			while ((line = br.readLine()) != null) {
				String[] lr = line.split(",");

				System.out.println("id: " + lr[0]);
				System.out.println("name: " + lr[1]);
				System.out.println("email: " + lr[2]);
				System.out.println("date: " + lr[3]);
				System.out.println();

				String[] nr = lr[1].split(" ");
				String newLine = lr[0] + "," + lr[1] + "," + lr[2] + "," + lr[3] + "," + nr[0] + "," + nr[1] + "\n";
				bw.write(newLine);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
