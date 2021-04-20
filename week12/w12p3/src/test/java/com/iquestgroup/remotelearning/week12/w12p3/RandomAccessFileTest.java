package com.iquestgroup.remotelearning.week12.w12p3;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week12.w12p3.exception.EmptyFileException;
import com.iquestgroup.remotelearning.week12.w12p3.exception.InvalidPathException;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class RandomAccessFileTest {

  private static final String VALID_FILE_PATH = "fileToAccess.txt";
  private static final String INVALID_FILE_PATH = "src/main/resources/fileToAccess.txt";
  private static final int EXPECTED_SIZE = 2;
  private static final int FIRST_NUMBER_TO_READ = 2;
  private static final int INDEX_FIRST_NUMBER_TO_READ = 0;
  private static final int SECOND_NUMBER_TO_READ = 3;
  private static final int INDEX_SECOND_NUMBER_TO_READ = 1;
  private FileWriter fileWriter;
  private FileReader fileReader;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testWriteToFileHappyFlow() {
    fileWriter.setFilePath(VALID_FILE_PATH);
    fileWriter.write();
    File file = new File(VALID_FILE_PATH);
    assertNotEquals(file.length(), 0);
  }

  @Test(expected = InvalidPathException.class)
  public void testWriteToFileInvalidPath() {
    fileWriter.setFilePath(INVALID_FILE_PATH);
    fileWriter.write();
  }

  @Test
  public void testReadFromFileHappyFlow() {
    fileWriter.setFilePath(VALID_FILE_PATH);
    fileWriter.write();
    fileReader.setFilePath(VALID_FILE_PATH);
    fileReader.read();
    int actualSize = fileReader.getReadNumbers().length;
    assertEquals(EXPECTED_SIZE, actualSize);
    assertEquals(FIRST_NUMBER_TO_READ, fileReader.getReadNumbers()[INDEX_FIRST_NUMBER_TO_READ]);
    assertEquals(SECOND_NUMBER_TO_READ, fileReader.getReadNumbers()[INDEX_SECOND_NUMBER_TO_READ]);
  }

  @Test(expected = InvalidPathException.class)
  public void testReadFromFileInvalidPath() {
    fileWriter.setFilePath(VALID_FILE_PATH);
    fileWriter.write();
    fileReader.setFilePath(INVALID_FILE_PATH);
    fileReader.read();
  }

  @Test(expected = EmptyFileException.class)
  public void testReadFromEmptyFile() {
    fileReader.setFilePath(VALID_FILE_PATH);
    fileReader.clearFile();
    fileReader.read();
    int actualSize = fileReader.getReadNumbers().length;
    System.out.println(actualSize);
  }

  @Test(expected = InvalidPathException.class)
  public void testClearFileInvalidPath() {
    fileWriter.setFilePath(VALID_FILE_PATH);
    fileWriter.write();
    fileReader.setFilePath(INVALID_FILE_PATH);
    fileReader.clearFile();
  }

  private void initData() {
    fileWriter = new IntegerFileWriter();
    fileReader = new PartialFileReader();
  }
}
