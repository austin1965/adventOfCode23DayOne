import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.example.CalibrationFileParser;
import org.junit.jupiter.api.Test;

public class CalibrationFileParserTest {

  @Test
  void shouldParseFileIntoCalibrationData() {
    // given
    CalibrationFileParser systemUnderTest = new CalibrationFileParser();
    List<List<String>> expectedCalibrationData = new ArrayList<>();
    expectedCalibrationData.add(List.of("1", "2"));
    expectedCalibrationData.add(List.of("3", "8"));
    expectedCalibrationData.add(List.of("1", "2", "3", "4", "5"));
    expectedCalibrationData.add(List.of("7"));

    File calibrationDataFile =
        new File("src/test/resources/shouldFindCalibrationValueDataForMultipleLines.txt");
    // when
    List<List<String>> actualCalibrationData =
        systemUnderTest.provideCalibrationData(calibrationDataFile);

    // then
    assertEquals(actualCalibrationData, expectedCalibrationData);
  }
}
