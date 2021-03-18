package com.iquestgroup.remotelearning.week5.w5p3;


import com.iquestgroup.remotelearning.week5.w5p3.models.SentencesGenerator;
import com.iquestgroup.remotelearning.week5.w5p3.models.StoryGenerator;

public class Main {

  public static void main(String[] args) {
    SentencesGenerator sentencesGenerator = new SentencesGenerator();
    sentencesGenerator.generateSentences();
    sentencesGenerator.outputSentences();

    StoryGenerator storyGenerator = new StoryGenerator(100, new SentencesGenerator());
    storyGenerator.generateStory();
    storyGenerator.outputStory();
  }
}
