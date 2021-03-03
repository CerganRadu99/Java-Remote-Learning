package com.iquestgroup.remotelearning.week3.p3.models;

public class Circle extends CompositeShape {

  private Shape center;
  private Shape radius;

  public Circle(Shape center, Shape radius) {
    this.radius = radius;
    this.center = center;
  }

  public Shape getCenter() {
    return center;
  }

  public void setCenter(Shape center) {
    this.center = center;
  }

  public Shape getRadius() {
    return radius;
  }

  public void setRadius(Shape radius) {
    this.radius = radius;
  }

  @Override
  public void addToShape(Shape shape) {
    if (shape instanceof Line) {
      radius = shape;
    } else if (shape instanceof Point) {
      center = shape;
    }
  }

  @Override
  public void renderShape() {
    System.out.println("---TRYING TO RENDER CIRCLE---");
    center.renderShape();
    radius.renderShape();
    System.out.println("Circle was rendered!");
  }
}
