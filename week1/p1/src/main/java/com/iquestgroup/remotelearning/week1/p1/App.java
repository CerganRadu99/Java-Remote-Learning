package com.iquestgroup.remotelearning.week1.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class App {

  private static final int FIRST_PERSONAL_DATA = 0;
  private static final int SECOND_PERSONAL_DATA = 1;
  private static final int THIRD_PERSONAL_DATA = 2;
  private static final int FORTH_PERSONAL_DATA = 3;

  App() {

  }

  public void outputPersonalities(HashSet<Personality> personalities) {
    for (Personality currentPersonality : personalities) {
      System.out.println(currentPersonality);
    }
  }

  public HashSet<Personality> filterOutDuplicatedEntries(List<Personality> personalities) {
    return new HashSet<>(personalities);
  }

  public ArrayList<Personality> storeInformation(List<String> fileLineByLine) {
    ArrayList<Personality> personalities = new ArrayList<>();
    for (String line : fileLineByLine) {
      String[] personalData = line.split(",");
      switch (personalData.length) {
        case (4):
          try {
            int dateOfBirth = Integer
                .parseInt(personalData[THIRD_PERSONAL_DATA].substring(SECOND_PERSONAL_DATA));
            int dateOfDeath = Integer
                .parseInt(personalData[FORTH_PERSONAL_DATA].substring(SECOND_PERSONAL_DATA));
            personalities.add(
                new Personality(personalData[FIRST_PERSONAL_DATA],
                    personalData[SECOND_PERSONAL_DATA].substring(SECOND_PERSONAL_DATA), dateOfBirth,
                    dateOfDeath));
          } catch (NumberFormatException e) {
            e.printStackTrace();
          }
          break;
        case (3):
          try {
            int dateOfBirth = Integer
                .parseInt(personalData[THIRD_PERSONAL_DATA].substring(FORTH_PERSONAL_DATA));
            personalities
                .add(new Personality(personalData[FIRST_PERSONAL_DATA],
                    personalData[SECOND_PERSONAL_DATA].substring(SECOND_PERSONAL_DATA), dateOfBirth));
          } catch (NumberFormatException e) {
            e.printStackTrace();
          }
          break;
      }
    }
    return personalities;
  }

  public List<String> readFileLineByLine(InputStreamReader inputReader) {
    List<String> fileLineByLine = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(inputReader);
      String line = reader.readLine();
      while (line != null) {
        fileLineByLine.add(line);
        line = reader.readLine();
      }
      reader.close();
      return fileLineByLine;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileLineByLine;
  }

  public void executeApp(InputStreamReader inputReader) {
    List<String> fileLineByLine = readFileLineByLine(inputReader);
    ArrayList<Personality> personalities = storeInformation(fileLineByLine);
    HashSet<Personality> noDuplicatedPersonalities = filterOutDuplicatedEntries(personalities);
    outputPersonalities(noDuplicatedPersonalities);
  }
}