package com.iquestgroup.remotelearning.week3.p3.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Line extends CompositeShape {

  private static final int MINIMUM_NUMBER_OF_POINTS = 2;
  private Set<Shape> points;

  public Line(Shape[] points) {
    if (points.length < MINIMUM_NUMBER_OF_POINTS) {
      throw new IllegalArgumentException("A line has at least two points !!!");
    } else {
      this.points = new HashSet<Shape>(Arrays.asList(points));
    }
  }

  public Set<Shape> getPoints() {
    return points;
  }

  public void setPoints(Set<Shape> points) {
    this.points = points;
  }

  @Override
  public void addToShape(Shape shape) {
    points.add(shape);
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
