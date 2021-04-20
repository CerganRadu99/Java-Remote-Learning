package com.iquestgroup.remotelearning.week12.w12p3;

public interface FileReader {

  void read();

  void setFilePath(String filePath);

  int[] getReadNumbers();

  void clearFile();
}
