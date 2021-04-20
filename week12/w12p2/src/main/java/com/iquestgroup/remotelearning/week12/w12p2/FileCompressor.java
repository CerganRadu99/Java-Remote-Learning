package com.iquestgroup.remotelearning.week12.w12p2;

import com.iquestgroup.remotelearning.week12.w12p2.exception.InvalidPathException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompressor {

  private static final int FIRST_INDEX = 0;
  private static final String ZIP_EXTENSION = ".zip";
  private static final char EXTENSION_DELIMITER = '.';

  public void zipFile(String filePath) {
    try {
      File file = new File(filePath);
      String zipFileName = file.getPath().substring(FIRST_INDEX, file.getPath().indexOf(EXTENSION_DELIMITER)).concat(ZIP_EXTENSION);

      FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
      CheckedOutputStream checksum = new CheckedOutputStream(fileOutputStream, new Adler32());

      ZipOutputStream zipOutputStream = new ZipOutputStream(checksum);
      zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

      byte[] bytes = Files.readAllBytes(Paths.get(filePath));
      zipOutputStream.write(bytes, FIRST_INDEX, bytes.length);
      zipOutputStream.closeEntry();
      zipOutputStream.close();
      System.out.println(checksum.getChecksum().getValue());
    } catch (IOException exception) {
      throw new InvalidPathException("The path is not a valid one or file does not exist!");
    }
  }
}
