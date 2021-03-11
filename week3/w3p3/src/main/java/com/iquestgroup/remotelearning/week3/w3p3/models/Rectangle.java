package com.iquestgroup.remotelearning.week3.w3p3.models;

public class Rectangle implements Shape {

  private static final int NUMBER_OF_EDGES = 4;
  private Line[] rectangleEdges;

  public Rectangle(Line[] rectangleEdges) {
    if (rectangleEdges.length != NUMBER_OF_EDGES) {
      throw new IllegalArgumentException("A rectangle has exactly 4 lines !!!");
    } else {
      this.rectangleEdges = rectangleEdges;
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
