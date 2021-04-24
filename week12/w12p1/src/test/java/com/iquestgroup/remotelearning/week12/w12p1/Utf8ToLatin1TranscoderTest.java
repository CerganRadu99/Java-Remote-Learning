package com.iquestgroup.remotelearning.week12.w12p1;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week12.w12p1.exception.TranscoderException;
import com.iquestgroup.remotelearning.week12.w12p1.models.Utf8ToLatin1Transcoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Before;
import org.junit.Test;

public class Utf8ToLatin1TranscoderTest {

  public static final String VALID_UTF8_FILE_PATH = "src/test/resources/utfToLatin/UTF8EncodedTextFile.txt";
  public static final String VALID_LATIN1_FILE_PATH = "src/test/resources/utfToLatin/Latin1EncodedTextFile.txt";
  public static final String INVALID_LATIN1_FILE_PATH = "src/test/utfToLatin/Latin1EncodedTextFile.txt";
  public static final String INVALID_UTF8_FILE_PATH = "src/test/utfToLatin/UTF8EncodedTextFile.txt";
  public static final String VALID_TRANSCODED_TEXT = "AR?T!%&";
  public static final int STRANGE_CHARACTERS_SIZE = 3;

  private Utf8ToLatin1Transcoder utf8ToLatin1Transcoder;

  @Before
  public void setup() {
    utf8ToLatin1Transcoder = new Utf8ToLatin1Transcoder(VALID_UTF8_FILE_PATH, VALID_LATIN1_FILE_PATH);
  }

  @Test(expected = TranscoderException.class)
  public void testTranscodeInvalidCharacterCoding() {
    utf8ToLatin1Transcoder.transcode();
  }

  @Test
  public void testStrangeCharacters() {
    try {
      utf8ToLatin1Transcoder.transcode();
    } catch (TranscoderException exception) {
      int actualStrangeCharactersSize = utf8ToLatin1Transcoder.getStrangeCharactersLength();
      assertEquals(STRANGE_CHARACTERS_SIZE, actualStrangeCharactersSize);
    }
  }

  @Test
  public void testTranscode_Happy_Flow() throws IOException {
    try {
      utf8ToLatin1Transcoder.transcode();
    } catch (TranscoderException exception) {
      FileInputStream fileInputStream = new FileInputStream(VALID_LATIN1_FILE_PATH);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
      BufferedReader buffReader = new BufferedReader(inputStreamReader);
      String actualTranscodedText = buffReader.readLine();
      assertEquals(VALID_TRANSCODED_TEXT, actualTranscodedText);
    }
  }

  @Test(expected = TranscoderException.class)
  public void testTranscodeInvalidPath() {
    utf8ToLatin1Transcoder.setUtf8FilePath(INVALID_UTF8_FILE_PATH);
    utf8ToLatin1Transcoder.setLatin1FilePath(INVALID_LATIN1_FILE_PATH);
    utf8ToLatin1Transcoder.transcode();
  }

}
