package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalibrationFileParser {

  public List<List<String>> provideCalibrationData(File scrambledCalibrationInfo) {
    List<List<String>> calibrationDataTable = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(scrambledCalibrationInfo))) {
      extractRowCalibrationData(br, calibrationDataTable);
    } catch (IOException exception) {
      System.out.printf("error: %s%n", exception);
    }

    return calibrationDataTable;
  }

  private static void extractRowCalibrationData(
      BufferedReader br, List<List<String>> calibrationDataTable) throws IOException {
    List<String> calibrationDataRow = new ArrayList<>();

    int rawDatum = br.read();
    while (rawDatum != -1) {
      char datum = (char) rawDatum;

      if (Character.isDigit(datum)) {
        int temp = Character.getNumericValue(datum);
        calibrationDataRow.add(String.valueOf(temp));
      } else if (datum == '\n') {
        calibrationDataTable.add(calibrationDataRow);
        calibrationDataRow = new ArrayList<>();
      }

      rawDatum = br.read();
    }
    calibrationDataTable.add(calibrationDataRow);
  }
}
