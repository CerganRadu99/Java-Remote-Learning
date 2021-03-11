package com.iquestgroup.remotelearning.week3.p3.models;

public class GraphicalObjectEditor {

  private final CompositeShape canvas = new Canvas();

  public GraphicalObjectEditor() {
  }

  public void addShapesToCanvas(Shape[] shapesToAddToCanvas) {
    for (int index = 0; index < shapesToAddToCanvas.length; index++) {
      canvas.addToShape(shapesToAddToCanvas[index]);
    }
  }

  public void render() {
    canvas.renderShape();
  }
}
