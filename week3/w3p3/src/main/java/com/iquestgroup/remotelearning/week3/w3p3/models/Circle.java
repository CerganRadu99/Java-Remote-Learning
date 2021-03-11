package com.iquestgroup.remotelearning.week3.w3p3.models;

public class Circle implements Shape {

  private Point center;
  private Line radius;

  public Circle(Point center, Line radius) {
    this.radius = radius;
    this.center = center;
  }

  @Override
  public void renderShape() {
    System.out.println("---TRYING TO RENDER CIRCLE---");
    center.renderShape();
    radius.renderShape();
    System.out.println("Circle was rendered!");
  }
}
