package org.example;

import java.io.*;
import java.util.List;

public class CalibrationUnscrambler {

  CalibrationFileParser fileParser = new CalibrationFileParser();

  public int unscramble(File scrambledCalibrationInfo) {
    List<List<String>> calibrationDataTable =
        fileParser.provideCalibrationData(scrambledCalibrationInfo);
    List<String> rowCalibrationValues = determineCalibrationValueOfTableRows(calibrationDataTable);
    return getCalibrationValue(rowCalibrationValues);
  }

  private static int getCalibrationValue(List<String> valuesForCalculation) {
    return valuesForCalculation.stream().map(Integer::parseInt).reduce(0, Integer::sum);
  }

  private static List<String> determineCalibrationValueOfTableRows(
      List<List<String>> calibrationDataTable) {

    return calibrationDataTable.stream()
        .map(CalibrationUnscrambler::retrieveRowCalibrationValue)
        .toList();
  }

  private static String retrieveRowCalibrationValue(List<String> list) {
    String result;
    if (list.size() == 1) {
      result = list.get(0) + list.get(0);
    } else {
      result = list.get(0) + list.get(list.size() - 1);
    }
    return result;
  }
}
