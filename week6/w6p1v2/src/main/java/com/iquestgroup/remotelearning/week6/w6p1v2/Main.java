package com.iquestgroup.remotelearning.week6.w6p1v2;

import com.iquestgroup.remotelearning.week6.w6p1v2.models.DateViewer;
import com.iquestgroup.remotelearning.week6.w6p1v2.models.DateViewerImpl;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    Date date = new Date();
    DateViewer dateViewerImpl = new DateViewerImpl(date);
    dateViewerImpl.displayDate();
  }
}
