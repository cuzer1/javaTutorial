package com.cengiz.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class ReadFromFileWritetoJSONFile {

	public static void main(String[] args) {

		JsonFactory factory = new JsonFactory();

		try (FileReader fr = new FileReader("input/dummyData.csv"); BufferedReader br = new BufferedReader(fr)) {

			// Skip header
			String headerLine = br.readLine();
			String[] hdr = headerLine.split(",");

			String line;

			try {
				JsonGenerator generator = factory.createGenerator(new File("output/dummyOutput.json"),
						JsonEncoding.UTF8);

				generator.writeStartArray();
				while ((line = br.readLine()) != null) {

					String[] l = line.split(",");

					generator.writeStartObject();
					generator.writeNumberField(hdr[0], Long.parseLong(l[0]));
					generator.writeStringField(hdr[1], l[1]);
					generator.writeStringField(hdr[2], l[2]);
					generator.writeStringField(hdr[3], l[3]);
					generator.writeEndObject();

				}
				generator.writeEndArray();
				generator.close();
				System.out.println("File created...");

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

}
