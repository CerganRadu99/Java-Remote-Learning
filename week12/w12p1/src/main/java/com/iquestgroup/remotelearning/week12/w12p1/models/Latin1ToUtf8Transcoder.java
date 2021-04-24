package com.iquestgroup.remotelearning.week12.w12p1.models;

import com.iquestgroup.remotelearning.week12.w12p1.exception.TranscoderException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Latin1ToUtf8Transcoder extends Transcoder {

  private String latin1FilePath;
  private String utf8FilePath;

  public void setLatin1FilePath(String latin1FilePath) {
    this.latin1FilePath = latin1FilePath;
  }

  public void setUtf8FilePath(String utf8FilePath) {
    this.utf8FilePath = utf8FilePath;
  }

  public Latin1ToUtf8Transcoder(String latin1FilePath, String utf8FilePath){
    this.latin1FilePath = latin1FilePath;
    this.utf8FilePath = utf8FilePath;
  }
  @Override
  public void transcode() {
    try {
      FileInputStream fileInputStream = new FileInputStream(latin1FilePath);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.ISO_8859_1);
      BufferedReader buffReader = new BufferedReader(inputStreamReader);
      String latin1String = buffReader.readLine();
      String utf8String = new String(latin1String.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
      writeTextToFile(utf8String, utf8FilePath);
    } catch (IOException exception) {
      throw new TranscoderException("IOException was thrown!");
    }
  }
}
