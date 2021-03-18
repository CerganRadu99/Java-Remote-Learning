package com.iquestgroup.remotelearning.week5.w5p3.models;


public class StoryGenerator {

  private final SentencesGenerator sentencesGenerator;
  private final int lengthOfStory;

  public StoryGenerator(int lengthOfStory, SentencesGenerator sentencesGenerator) {
    super();
    this.lengthOfStory = lengthOfStory;
    this.sentencesGenerator = sentencesGenerator;
  }

  public void generateStory() {
    for (int i = 0; i < lengthOfStory; i++) {
      StringBuilder stringBuilder = sentencesGenerator.createSentence();
      String sentence = sentencesGenerator.makeSentencePrintable(stringBuilder);
      sentencesGenerator.getDisplay().getTextArea().append(sentence);
    }
  }

  public void outputStory() {
    sentencesGenerator.getDisplay().configurePanel();
    sentencesGenerator.getDisplay().configureFrame();
    sentencesGenerator.getDisplay().showFrame();
  }
}
