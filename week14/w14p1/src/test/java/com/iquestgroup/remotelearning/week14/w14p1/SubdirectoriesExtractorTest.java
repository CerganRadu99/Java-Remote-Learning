package com.iquestgroup.remotelearning.week14.w14p1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubdirectoriesExtractorTest {

  public static final String DIRECTORY_PATH = "src/test/resources/ParentDirectory";
  public static final int EXPECTED_NUMBER_OF_DIRECTORIES = 3;
  private static File parentDirectory;
  private SubdirectoriesExtractor subdirectoriesExtractor;

  @BeforeClass
  public static void setupBeforeClass() {
    parentDirectory = new File(DIRECTORY_PATH);
  }

  @Before
  public void setup() {
    subdirectoriesExtractor = new SubdirectoriesExtractor();
  }

  @Test
  public void testGetSubdirectoriesUsingLambda_HappyFlow() {
    File[] childDirectories = subdirectoriesExtractor.getSubdirectoriesUsingLambda(parentDirectory);
    int actualNumberOfDirectories = childDirectories.length;
    assertEquals(EXPECTED_NUMBER_OF_DIRECTORIES, actualNumberOfDirectories);
  }

  @Test
  public void testGetSubdirectoriesUsingMethodExpression_HappyFlow() {
    File[] childDirectories = subdirectoriesExtractor.getSubdirectoriesUsingMethodExpression(parentDirectory);
    int actualNumberOfDirectories = childDirectories.length;
    assertEquals(EXPECTED_NUMBER_OF_DIRECTORIES, actualNumberOfDirectories);
  }
}
