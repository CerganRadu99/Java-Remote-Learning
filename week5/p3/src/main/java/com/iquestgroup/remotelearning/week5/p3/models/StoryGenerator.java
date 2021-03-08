package com.iquestgroup.remotelearning.week5.p3.models;


public class StoryGenerator extends SentencesGenerator {

  private int lengthOfStory;

  public StoryGenerator(int lengthOfStory) {
    super();
    this.lengthOfStory = lengthOfStory;
  }

  public void generateSentences() {
    for (int i = 0; i < lengthOfStory; i++) {
      stringBuilder = createSentence();
      String sentence = makeSentencePrintable(stringBuilder);
      display.getTextArea().append(sentence);
      stringBuilder.setLength(LENGTH_WHEN_STRING_BUILDER_EMPTY);
    }
  }
}
