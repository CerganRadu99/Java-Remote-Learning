package com.iquestgroup.remotelearning.week8.w8p4.models;

import java.util.Objects;

public class Train {

  private final int trainNumber;
  private final String trainType;
  private final int noWagons;

  public Train(int trainNumber, String trainType, int noWagons) {
    this.trainNumber = trainNumber;
    this.trainType = trainType;
    this.noWagons = noWagons;
  }

  @Override
  public String toString() {
    return "Train{" +
        "trainNumber=" + trainNumber +
        ", trainType='" + trainType + '\'' +
        ", noWagons=" + noWagons +
        '}';
  }

  @Override
  public int hashCode() {
    //return 3;
    return Objects.hash(trainNumber, trainType, noWagons);
  }
}