package com.iquestgroup.remotelearning.week3.w3p3.models;

import java.util.Objects;

public class Point implements Shape {

  private int xCoordinate;
  private int yCoordinate;

  public Point(int xCoordinate, int yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return xCoordinate == point.xCoordinate && yCoordinate == point.yCoordinate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(xCoordinate, yCoordinate);
  }

  @Override
  public String toString() {
    return "Point{" +
        "xCoordinate=" + xCoordinate +
        ", yCoordinate=" + yCoordinate +
        '}';
  }

  @Override
  public void renderShape() {
    System.out.println("Point was rendered!");
  }
}
