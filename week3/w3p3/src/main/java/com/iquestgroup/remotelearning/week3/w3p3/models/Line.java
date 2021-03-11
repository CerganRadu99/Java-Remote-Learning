package com.iquestgroup.remotelearning.week3.p3.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Line implements Shape {

  private static final int MINIMUM_NUMBER_OF_POINTS = 2;
  private Set<Point> points;

  public Line(Point[] points) {
    if (points.length < MINIMUM_NUMBER_OF_POINTS) {
      throw new IllegalArgumentException("A line has at least two points !!!");
    } else {
      this.points = new HashSet<>(Arrays.asList(points));
    }
  }

  @Override
  public void renderShape() {
    System.out.println("---TRYING TO RENDER LINE---");
    for (Shape shape : points) {
      shape.renderShape();
    }
    System.out.println("Line was rendered!");
  }
}
