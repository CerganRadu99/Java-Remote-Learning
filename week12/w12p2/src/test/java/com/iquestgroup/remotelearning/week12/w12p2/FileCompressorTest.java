package com.iquestgroup.remotelearning.week12.w12p2;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week12.w12p2.exception.InvalidPathException;
import java.io.File;
import java.io.FilenameFilter;
import org.junit.Before;
import org.junit.Test;

public class FileCompressorTest {

  public static final String FILE_VALID_PATH = "src/test/resources/fileToCompress.txt";
  public static final String ARCHIVE_VALID_PATH = "src/test/resources/fileToCompress.zip";
  public static final String FILE_INVALID_PATH = "src/main/resources/fileToCompress.txt";
  public static final String DIRECTORY_NAME = "src/test/resources";
  public static final double COMPRESSION_RATIO = 0.027299060771864118;
  public static final int NUMBER_OF_ZIP_FILES = 1;
  public static final String ZIP_EXTENSION = "zip";
  private FileCompressor fileCompressor;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testZipFileHappyFlow() {
    fileCompressor.zipFile(FILE_VALID_PATH);
    File fileToSearch = new File(DIRECTORY_NAME);
    FilenameFilter zipExtension = new ZipExtension(ZIP_EXTENSION);
    String[] zipExtensionFiles = fileToSearch.list(zipExtension);
    assertEquals(NUMBER_OF_ZIP_FILES, zipExtensionFiles.length);
  }

  @Test(expected = InvalidPathException.class)
  public void testZipFileInvalidPath() {
    fileCompressor.zipFile(FILE_INVALID_PATH);
  }

  @Test
  public void testCompressionRatio(){
    fileCompressor.zipFile(FILE_VALID_PATH);
    File txtFile = new File(FILE_VALID_PATH);
    File zipFile = new File(ARCHIVE_VALID_PATH);
    double actualCompressionRatio = (double)zipFile.length() / txtFile.length();
    assertEquals(COMPRESSION_RATIO, actualCompressionRatio, 0);
  }
  
  private void initData() {
    fileCompressor = new FileCompressor();
  }
}
