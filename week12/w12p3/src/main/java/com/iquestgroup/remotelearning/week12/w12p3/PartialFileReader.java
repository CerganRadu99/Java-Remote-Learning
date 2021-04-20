package com.iquestgroup.remotelearning.week12.w12p3;

import com.iquestgroup.remotelearning.week12.w12p3.exception.EmptyFileException;
import com.iquestgroup.remotelearning.week12.w12p3.exception.InvalidPathException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PartialFileReader implements FileReader {

  private static final int NUMBER_OF_READ_NUMBERS = 2;
  private static final int NUMBER_OF_BYTES_INTEGER = 4;
  private static final int EMPTY_FILE_LENGTH = 0;
  private static final String EMPTY_FILE_EXCEPTION_MESSAGE = "The file is empty!";
  private static final String INVALID_PATH_EXCEPTION_MESSAGE = "The path is not a valid one or file does not exist!";
  private static final String READ = "r";
  private static final String READ_WRITE = "rw";
  private final int[] readNumbers;
  private String filePath;
  private int positionToRead = 2;

  public PartialFileReader() {
    readNumbers = new int[NUMBER_OF_READ_NUMBERS];
  }

  @Override
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public int[] getReadNumbers() {
    return readNumbers;
  }

  @Override
  public void clearFile() {
    try {
      RandomAccessFile rf = new RandomAccessFile(filePath, READ_WRITE);
      rf.setLength(EMPTY_FILE_LENGTH);
      rf.close();
    } catch (IOException exception) {
      throw new InvalidPathException(INVALID_PATH_EXCEPTION_MESSAGE);
    }
  }

  @Override
  public void read() {
    try {
      RandomAccessFile rf = new RandomAccessFile(filePath, READ);
      File file = new File(filePath);
      if (file.length() == EMPTY_FILE_LENGTH) {
        throw new EmptyFileException(EMPTY_FILE_EXCEPTION_MESSAGE);
      }
      for (int index = 0; index < NUMBER_OF_READ_NUMBERS; index++) {
        rf.seek((long) positionToRead * NUMBER_OF_BYTES_INTEGER);
        readNumbers[index] = rf.readInt();
        positionToRead++;
      }
      rf.close();
    } catch (IOException exception) {
      throw new InvalidPathException(INVALID_PATH_EXCEPTION_MESSAGE);
    }
  }
}
