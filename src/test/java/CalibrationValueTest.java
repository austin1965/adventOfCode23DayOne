import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationValueTest {

    @Disabled("WIP")
    @ParameterizedTest
    @CsvSource({"src/test/resources/shouldFindCalibrationValueData.txt,142", "src/test/resources/shouldFindCalibrationValueData2.txt,12"})
    void shouldFindCalibrationValue(String scrambledCalibrationFile, int expectedCalibrationResult) {
        //given
        CalibrationUnscrambler systemUnderTest = new CalibrationUnscrambler();
        File scrambledCalibrationInfo = new File(scrambledCalibrationFile);

        //when
        int calibrationValue = systemUnderTest.unscramble(scrambledCalibrationInfo);

        //then
        assertEquals(calibrationValue, expectedCalibrationResult);

    }

}
