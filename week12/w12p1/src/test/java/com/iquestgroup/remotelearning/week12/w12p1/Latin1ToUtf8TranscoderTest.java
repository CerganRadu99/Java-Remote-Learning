package com.iquestgroup.remotelearning.week12.w12p1;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week12.w12p1.exception.TranscoderException;
import com.iquestgroup.remotelearning.week12.w12p1.models.Latin1ToUtf8Transcoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Before;
import org.junit.Test;

public class Latin1ToUtf8TranscoderTest {

  public static final String VALID_LATIN1_FILE_PATH = "src/test/resources/latinToUtf/Latin1EncodedTextFile.txt";
  public static final String INVALID_LATIN1_FILE_PATH = "src/test/latin1ToUtf/Latin1EncodedTextFile.txt";
  public static final String INVALID_UTF8_FILE_PATH = "src/test/latin1ToUtf/UTF8EncodedTextFile.txt";
  public static final String VALID_UTF8_FILE_PATH = "src/test/resources/latinToUtf/UTF8EncodedTextFile.txt";
  public static final String VALID_TRANSCODED_TEXT = "Ã¼zÃ¼m";
  private Latin1ToUtf8Transcoder latin1ToUtf8Transcoder;

  @Before
  public void setup() {
    latin1ToUtf8Transcoder = new Latin1ToUtf8Transcoder(VALID_LATIN1_FILE_PATH, VALID_UTF8_FILE_PATH);
  }

  @Test
  public void testTranscode_HappyFlow() throws IOException {
    latin1ToUtf8Transcoder.transcode();
    FileInputStream fileInputStream = new FileInputStream(VALID_UTF8_FILE_PATH);
    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
    BufferedReader buffReader = new BufferedReader(inputStreamReader);
    String actualTranscodedText = buffReader.readLine();
    assertEquals(VALID_TRANSCODED_TEXT, actualTranscodedText);
  }

  @Test(expected = TranscoderException.class)
  public void testTranscodeInvalidPath() {
    latin1ToUtf8Transcoder.setLatin1FilePath(INVALID_LATIN1_FILE_PATH);
    latin1ToUtf8Transcoder.setUtf8FilePath(INVALID_UTF8_FILE_PATH);
    latin1ToUtf8Transcoder.transcode();
  }
}
