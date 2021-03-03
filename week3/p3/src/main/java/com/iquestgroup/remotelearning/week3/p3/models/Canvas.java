package com.iquestgroup.remotelearning.week3.p3.models;

import java.util.ArrayList;
import java.util.List;

public class Canvas extends CompositeShape {

  private List<Shape> shapes;

  public Canvas() {
    shapes = new ArrayList<Shape>();
  }

  public List<Shape> getShapes() {
    return shapes;
  }

  public void setShapes(List<Shape> shapes) {
    this.shapes = shapes;
  }

  @Override
  public void addToShape(Shape shape) {
    shapes.add(shape);
  }

  @Override
  public void renderShape() {
    System.out.println("---TRYING TO RENDER CANVAS---");
    for (Shape shape : shapes) {
      shape.renderShape();
    }
    System.out.println("Canvas was rendered!");
  }
}
