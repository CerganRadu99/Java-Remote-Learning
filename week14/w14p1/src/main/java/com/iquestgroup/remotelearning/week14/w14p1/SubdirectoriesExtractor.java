package com.iquestgroup.remotelearning.week14.w14p1;

import java.io.File;

public class SubdirectoriesExtractor {

  public File[] getSubdirectoriesUsingLambda(File parentDirectory) {
    return parentDirectory.listFiles(file -> file.isDirectory());
  }

  public File[] getSubdirectoriesUsingMethodExpression(File parentDirectory) {
    return parentDirectory.listFiles(File::isDirectory);
  }
}
