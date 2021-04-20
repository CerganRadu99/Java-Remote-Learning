package com.iquestgroup.remotelearning.week12.w12p1.models;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Latin1ToUtf8Transcoder extends Transcoder {

  private static final String LATIN1_FILE_PATH = "week12/w12p1/src/main/resources/latinToUtf/Latin1EncodedTextFile.txt";
  private static final String UTF8_FILE_PATH = "week12/w12p1/src/main/resources/latinToUtf/UTF8EncodedTextFile.txt";

  @Override
  public void transcode() {
    try {
      FileInputStream fileInputStream = new FileInputStream(LATIN1_FILE_PATH);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.ISO_8859_1);
      BufferedReader buffReader = new BufferedReader(inputStreamReader);
      String latin1String = buffReader.readLine();
      String utf8String = new String(latin1String.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
      writeTextToFile(utf8String, UTF8_FILE_PATH);
    } catch (IOException exception) {
      throw new RuntimeException();
    }
  }
}
