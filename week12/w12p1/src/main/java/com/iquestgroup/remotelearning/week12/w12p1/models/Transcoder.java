package com.iquestgroup.remotelearning.week12.w12p1.models;

import com.iquestgroup.remotelearning.week12.w12p1.exception.TranscoderException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Transcoder {

  private static final String STRING_DELIMITER = " ";
  private static final String LINE_DELIMITER = "\n";

  public abstract void transcode();

  protected void writeTextToFile(String textToWrite, String fileName) {
    String[] textToWriteLineByLine = textToWrite.split(STRING_DELIMITER);
    try {
      FileWriter fileWriter = new FileWriter(fileName);
      for (String currentLine : textToWriteLineByLine) {
        fileWriter.write(currentLine);
        fileWriter.write(LINE_DELIMITER);
      }
      fileWriter.close();
    } catch (IOException exception) {
      throw new TranscoderException("IOException was thrown!");
    }
  }
}
