package com.iquestgroup.remotelearning.week8.w8p3.models;

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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Train train = (Train) o;
    return trainNumber == train.trainNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(trainNumber);
  }
}
