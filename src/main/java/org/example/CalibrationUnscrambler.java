package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalibrationUnscrambler {
    public int unscramble(File scrambledCalibrationInfo) {
        List<List<String>> calibrationDataTable = extractCalibrationData(scrambledCalibrationInfo);
        List<String> valuesForCalculation = determineCalibrationValues(calibrationDataTable);
        return getCalibrationValue(valuesForCalculation);
    }

    private static int getCalibrationValue(List<String> valuesForCalculation) {
        return valuesForCalculation.stream().map(Integer::parseInt).reduce(0, Integer::sum);
    }

    private static List<String> determineCalibrationValues(List<List<String>> calibrationDataTable) {

        return calibrationDataTable.stream().map(list -> {
            String  result;
            if (list.size() == 1) {
                result = list.get(0) + list.get(0);
            }
            else {
                result = list.get(0) + list.get(list.size() - 1);
            }
            return result;
        }).toList();
    }

    private static List<List<String>> extractCalibrationData(File scrambledCalibrationInfo) {
        List<List<String>> calibrationDataTable = new ArrayList<>();

        try (BufferedReader br =  new BufferedReader(new FileReader(scrambledCalibrationInfo))) {
            List<String> calibrationDataRow = new ArrayList<>();

            int rawDatum = br.read();
            while(rawDatum != -1) {
                char datum = (char) rawDatum;

                if (Character.isDigit(datum)) {
                    int temp = Character.getNumericValue(datum);
                    calibrationDataRow.add(String.valueOf(temp));
                }
                else if (datum == '\n') {
                    calibrationDataTable.add(calibrationDataRow);
                    calibrationDataRow = new ArrayList<>();
                }

                rawDatum = br.read();
            }
            calibrationDataTable.add(calibrationDataRow);
        }
        catch (IOException exception) {
            System.out.printf("error: %s%n", exception);
        }

        return calibrationDataTable;
    }
}
