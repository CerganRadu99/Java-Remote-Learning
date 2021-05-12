package com.iquestgroup.remotelearning.week14.w14p2;

import com.iquestgroup.remotelearning.week14.w14p2.exception.EmptyStreamsException;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamsZipper {

  private StreamsZipper() {

  }

  public static <T> Stream<T> zip(Stream<T> firstStreamToZip, Stream<T> secondStreamToZip) {
    Iterator<T> firstStreamIterator = firstStreamToZip.iterator();
    Iterator<T> secondStreamIterator = secondStreamToZip.iterator();
    if (isEmpty(firstStreamIterator) && isEmpty(secondStreamIterator)) {
      throw new EmptyStreamsException("Both streams are empty!!!");
    }
    Stream<T> zippedStream = zipStreams(firstStreamIterator, secondStreamIterator);
    zippedStream = clearStream(firstStreamIterator, zippedStream);
    zippedStream = clearStream(secondStreamIterator, zippedStream);
    return zippedStream;
  }

  private static <T> boolean isEmpty(Iterator<T> streamIterator) {
    return !streamIterator.hasNext();
  }

  private static <T> Stream<T> clearStream(Iterator<T> streamIterator, Stream<T> zippedStream) {
    while (streamIterator.hasNext()) {
      zippedStream = Stream.concat(zippedStream, Stream.of(streamIterator.next()));
    }
    return zippedStream;
  }

  private static <T> Stream<T> zipStreams(Iterator<T> firstStreamIterator, Iterator<T> secondStreamIterator) {
    Stream<T> zippedStream = Stream.empty();
    while (firstStreamIterator.hasNext() && secondStreamIterator.hasNext()) {
      zippedStream = Stream.concat(zippedStream, Stream.of(firstStreamIterator.next(), secondStreamIterator.next()));
    }
    return zippedStream;
  }
}
