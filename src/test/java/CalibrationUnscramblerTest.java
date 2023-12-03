import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import org.example.CalibrationUnscrambler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalibrationUnscramblerTest {

  @ParameterizedTest
  @CsvSource({
    "src/test/resources/shouldFindCalibrationValueDataForMultipleLines.txt,142",
    "src/test/resources/shouldFindCalibrationValueForOneLine.txt,12",
    "src/test/resources/shouldFindCalibrationValueDataForSpelledOutNumbers.txt,281"
  })
  void shouldFindCalibrationValue(String scrambledCalibrationFile, int expectedCalibrationResult) {
    // given
    CalibrationUnscrambler systemUnderTest = new CalibrationUnscrambler();
    File scrambledCalibrationInfo = new File(scrambledCalibrationFile);

    // when
    int calibrationValue = systemUnderTest.unscramble(scrambledCalibrationInfo);

    // then
    assertEquals(calibrationValue, expectedCalibrationResult);
  }
}
