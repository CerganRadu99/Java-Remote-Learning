package com.iquestgroup.remotelearning.week12.w12p1.models;

import com.iquestgroup.remotelearning.week12.w12p1.exception.TranscoderException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Utf8ToLatin1Transcoder extends Transcoder {

  private static final String STRING_DELIMITER = " ";
  private final ArrayList<Character> strangeCharacters = new ArrayList<>();
  private String utf8FilePath;
  private String latin1FilePath;

  public Utf8ToLatin1Transcoder(String utf8FilePath, String latin1FilePath) {
    this.utf8FilePath = utf8FilePath;
    this.latin1FilePath = latin1FilePath;
  }

  public void setUtf8FilePath(String utf8FilePath) {
    this.utf8FilePath = utf8FilePath;
  }

  public void setLatin1FilePath(String latin1FilePath) {
    this.latin1FilePath = latin1FilePath;
  }

  @Override
  public void transcode() {
    try {
      StringBuilder fileContentAsStringBuilder = readFileLineByLine();
      String utf8String2 = decode(fileContentAsStringBuilder.toString(), StandardCharsets.UTF_8);
      CharsetEncoder charsetEncoder = StandardCharsets.ISO_8859_1.newEncoder();
      charsetEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
      encode(charsetEncoder, utf8String2);
    } catch (IOException exception) {
      throw new TranscoderException("IOException was thrown!");
    }
  }

  public int getStrangeCharactersLength() {
    return strangeCharacters.size();
  }

  private void encode(CharsetEncoder encoder, String stringToEncode) throws CharacterCodingException {
    try {
      encoder.encode(CharBuffer.wrap(stringToEncode));
    } catch (CharacterCodingException exception) {
      encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
      ByteBuffer byteBuffer = encoder.encode(CharBuffer.wrap(stringToEncode));
      String latin2String = StandardCharsets.ISO_8859_1.decode(byteBuffer).toString();
      writeTextToFile(latin2String, latin1FilePath);
      char[] latin2StringAsCharArray = latin2String.toCharArray();
      char[] utf8String2AsCharArray = stringToEncode.toCharArray();
      for (int index = 0; index < latin2StringAsCharArray.length; index++) {
        if (latin2StringAsCharArray[index] != utf8String2AsCharArray[index]) {
          strangeCharacters.add(utf8String2AsCharArray[index]);
        }
      }
      throw new TranscoderException("CharacterCodingException was thrown!");
    }
  }

  private String decode(String textToTranscode, Charset charset) {
    CharsetDecoder charsetDecoder = charset.newDecoder();
    String decodedText;
    try {
      decodedText = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(textToTranscode.getBytes()), charsetDecoder)).readLine();
    } catch (IOException exception) {
      throw new TranscoderException("IOException was thrown!");
    }
    return decodedText;
  }

  private StringBuilder readFileLineByLine() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(utf8FilePath));
    String currentLine;
    StringBuilder resultStringBuilder2 = new StringBuilder();
    while ((currentLine = bufferedReader.readLine()) != null) {
      resultStringBuilder2.append(currentLine).append(STRING_DELIMITER);
    }
    return resultStringBuilder2;
  }
}
