package com.iquestgroup.remotelearning.week14.w14p2;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week14.w14p2.exception.EmptyStreamsException;
import java.util.stream.Stream;
import org.junit.Test;

public class StreamsZipperTest {

  public static final Stream<Integer> FIRST_INTEGER_STREAM = Stream.of(24, 15, 99);
  public static final Stream<Integer> SECOND_INTEGER_STREAM = Stream.of(-1, 12, 33, 45, 11);
  public static final Stream<String> FIRST_STRING_STREAM = Stream.of("cow", "dog", "cat", "mouse", "lion");
  public static final Stream<String> SECOND_STRING_STREAM = Stream.of("house", "door", "apple");
  public static final Stream<String> FIRST_EMPTY_STREAM = Stream.empty();
  public static final Stream<String> SECOND_EMPTY_STREAM = Stream.empty();
  public static final long EXPECTED_SIZE_ZIPPED_STREAM = 8;

  @Test
  public void testZipIntegerStreams() {
    Stream<Integer> zippedStream = StreamsZipper.zip(FIRST_INTEGER_STREAM, SECOND_INTEGER_STREAM);
    long actualSizeZippedStream = zippedStream.count();
    assertEquals(EXPECTED_SIZE_ZIPPED_STREAM, actualSizeZippedStream);
  }

  @Test
  public void testZipStringStreams() {
    Stream<String> zippedStream = StreamsZipper.zip(FIRST_STRING_STREAM, SECOND_STRING_STREAM);
    long actualSizeZippedStream = zippedStream.count();
    assertEquals(EXPECTED_SIZE_ZIPPED_STREAM, actualSizeZippedStream);
  }

  @Test(expected = EmptyStreamsException.class)
  public void testZipEmptyStreams() {
    StreamsZipper.zip(FIRST_EMPTY_STREAM, SECOND_EMPTY_STREAM);
  }
}
