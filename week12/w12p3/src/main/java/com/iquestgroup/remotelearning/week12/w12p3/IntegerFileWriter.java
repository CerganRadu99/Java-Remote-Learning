package com.iquestgroup.remotelearning.week12.w12p3;

import com.iquestgroup.remotelearning.week12.w12p3.exception.InvalidPathException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IntegerFileWriter implements FileWriter {

  private static final String INVALID_PATH_EXCEPTION_MESSAGE = "The path is not a valid one or file does not exist!";
  private static final String READ_WRITE = "rw";
  private static final int NUMBER_OF_INTEGERS_TO_WRITE = 4;
  private String filePath;

  @Override
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public void write() {
    try {
      RandomAccessFile rf = new RandomAccessFile(filePath, READ_WRITE);
      for (int numberToWrite = 0; numberToWrite < NUMBER_OF_INTEGERS_TO_WRITE; numberToWrite++) {
        rf.writeInt(numberToWrite);
      }
      rf.close();
    } catch (IOException exception) {
      throw new InvalidPathException(INVALID_PATH_EXCEPTION_MESSAGE);
    }
  }
}
