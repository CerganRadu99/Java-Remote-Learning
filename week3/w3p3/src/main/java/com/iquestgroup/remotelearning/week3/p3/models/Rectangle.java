package com.iquestgroup.remotelearning.week3.p3.models;

public class Rectangle extends CompositeShape {

  private static final int NUMBER_OF_EDGES = 4;
  private Shape[] rectangleEdges;

  public Rectangle(Shape[] rectangleEdges) {
    if (rectangleEdges.length != NUMBER_OF_EDGES) {
      throw new IllegalArgumentException("A rectangle has exactly 4 lines !!!");
    } else {
      this.rectangleEdges = rectangleEdges;
    }
  }

  public Shape[] getRectangleEdges() {
    return rectangleEdges;
  }

  public void setRectangleEdges(Shape[] rectangleEdges) {
    this.rectangleEdges = rectangleEdges;
  }

  @Override
  public void addToShape(Shape shape) {
    if (rectangleEdges.length < NUMBER_OF_EDGES) {
      rectangleEdges[rectangleEdges.length] = shape;
    } else {
      System.out.println("A rectangle has no more than 4 lines !!!");
    }
  }

  @Override
  public void renderShape() {
    System.out.println("---TRYING TO RENDER RECTANGLE---");
    for (Shape shape : rectangleEdges) {
      shape.renderShape();
    }
    System.out.println("Rectangle was rendered!");
  }
}
