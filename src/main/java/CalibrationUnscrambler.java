import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalibrationUnscrambler {
    public int unscramble(File scrambledCalibrationInfo) {

        List<List<Integer>> calibrationDataTable = extractCalibrationData(scrambledCalibrationInfo);
        System.out.println(calibrationDataTable);

        return 142;
    }

    private static List<List<Integer>> extractCalibrationData(File scrambledCalibrationInfo) {
        List<List<Integer>> calibrationDataTable = new ArrayList<>();

        try (BufferedReader br =  new BufferedReader(new FileReader(scrambledCalibrationInfo))) {
            List<Integer> calibrationDataRow = new ArrayList<>();

            int rawDatum = br.read();
            while(rawDatum != -1) {
                char datum = (char) rawDatum;

                if (Character.isDigit(datum)) {
                    calibrationDataRow.add(Character.getNumericValue(datum));
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
