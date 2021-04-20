package com.iquestgroup.remotelearning.week12.w12p1;

import com.iquestgroup.remotelearning.week12.w12p1.models.Latin1ToUtf8Transcoder;
import com.iquestgroup.remotelearning.week12.w12p1.models.Transcoder;
import com.iquestgroup.remotelearning.week12.w12p1.models.Utf8ToLatin1Transcoder;

public class Main {

  public static void main(String[] args) {
    Transcoder latin1ToUtf8Transcoder = new Latin1ToUtf8Transcoder();
    latin1ToUtf8Transcoder.transcode();
    Transcoder utf8ToLatin1Transcoder = new Utf8ToLatin1Transcoder();
    utf8ToLatin1Transcoder.transcode();
  }
}
