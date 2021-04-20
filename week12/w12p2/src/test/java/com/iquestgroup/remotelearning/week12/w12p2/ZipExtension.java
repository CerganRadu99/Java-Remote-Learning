package com.iquestgroup.remotelearning.week12.w12p2;

import java.io.File;
import java.io.FilenameFilter;

public class ZipExtension implements FilenameFilter {

  private final String extension;

  public ZipExtension(String extension) {
    this.extension = "." + extension;
  }

  @Override
  public boolean accept(File dir, String name) {
    return name.endsWith(extension);
  }
}
