package org.example;

import java.io.File;

public class Main {
  public static void main(String[] args) {
    CalibrationUnscrambler calibrationUnscambler = new CalibrationUnscrambler();
    int result = calibrationUnscambler.unscramble(new File("src/main/resources/puzzle.txt"));
    System.out.println(result);
  }
}
