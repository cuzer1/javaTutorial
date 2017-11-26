package com.cengiz.examples;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFromJSONWritetoFlatFile {

	public static void main(String[] args) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		List<Record> listRecs = mapper.readValue(new File("output/dummyOutput.json"),
				new TypeReference<List<Record>>() {
				});

		for (Record record : listRecs) {
			System.out.println(record);

		}

	}

}
