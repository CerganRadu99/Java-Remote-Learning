package com.iquestgroup.remotelearning.week3.p3;

import com.iquestgroup.remotelearning.week3.p3.models.Circle;
import com.iquestgroup.remotelearning.week3.p3.models.GraphicalObjectEditor;
import com.iquestgroup.remotelearning.week3.p3.models.Line;
import com.iquestgroup.remotelearning.week3.p3.models.Point;
import com.iquestgroup.remotelearning.week3.p3.models.Rectangle;
import com.iquestgroup.remotelearning.week3.p3.models.Shape;

public class Main {

  private Shape[] getPointsForLine() {
    return new Shape[]{new Point(1, 1), new Point(1, 2), new Point(1, 3)};
  }

  private Shape[] getPointsForFirstLengthOfRectangle() {
    return new Shape[]{new Point(2, 5), new Point(3, 5), new Point(4, 5), new Point(5, 5)};
  }

  private Shape[] getPointsForSecondLengthOfRectangle() {
    return new Shape[]{new Point(2, 4), new Point(3, 4), new Point(4, 4), new Point(5, 4)};
  }

  private Shape[] getPointsForFirstWidthOfRectangle() {
    return new Shape[]{new Point(2, 4), new Point(2, 5)};
  }

  private Shape[] getPointsForSecondWidthOfRectangle() {
    return new Shape[]{new Point(5, 4), new Point(5, 5)};
  }

  private Shape[] getLinesForRectangle() {
    return new Shape[]{new Line(getPointsForFirstLengthOfRectangle()),
        new Line(getPointsForSecondLengthOfRectangle()),
        new Line(getPointsForFirstWidthOfRectangle()),
        new Line(getPointsForSecondWidthOfRectangle())};
  }

  private Shape getCenterOfCircle() {
    return new Point(3, 3);
  }

  private Shape[] getPointsForRadius() {
    return new Shape[]{getCenterOfCircle(), new Point(4, 3), new Point(5, 3), new Point(6, 3)};
  }

  private Shape getRadiusOfCircle() {
    return new Line(getPointsForRadius());
  }

  private int getXCoordinate() {
    return 2;
  }

  private int getYCoordinate() {
    return 3;
  }

  public Shape[] createShapeArray() {
    return new Shape[]{new Point(getXCoordinate(), getYCoordinate()), new Line(getPointsForLine()),
        new Rectangle(getLinesForRectangle()),
        new Circle(getCenterOfCircle(), getRadiusOfCircle())};
  }

  public static void main(String[] args) {
    Main main = new Main();
    GraphicalObjectEditor graphicalObjectEditor = new GraphicalObjectEditor();
    graphicalObjectEditor.addShapesToCanvas(main.createShapeArray());
    graphicalObjectEditor.render();
  }
}
