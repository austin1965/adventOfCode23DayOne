import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalibrationValueTest {

    @Test
    void shouldFindCalibrationValue() {
        //given
        CalibrationUnscrambler systemUnderTest = new CalibrationUnscrambler();
        File scrambledCalibrationInfo = new File("src/test/resources/example.txt");

        //when
        int calibrationValue = systemUnderTest.unscramble(scrambledCalibrationInfo);

        //then
        assertEquals(calibrationValue, 77);

    }

}
