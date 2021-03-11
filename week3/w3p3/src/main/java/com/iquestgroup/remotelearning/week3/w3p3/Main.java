package com.iquestgroup.remotelearning.week3.w3p3;

import com.iquestgroup.remotelearning.week3.w3p3.models.Circle;
import com.iquestgroup.remotelearning.week3.w3p3.models.GraphicalObjectEditor;
import com.iquestgroup.remotelearning.week3.w3p3.models.Line;
import com.iquestgroup.remotelearning.week3.w3p3.models.Point;
import com.iquestgroup.remotelearning.week3.w3p3.models.Rectangle;
import com.iquestgroup.remotelearning.week3.w3p3.models.Shape;

public class Main {

  private Point[] getPointsForLine() {
    Point firstPoint = new Point(1, 1);
    Point secondPoint = new Point(1, 2);
    Point thirdPoint = new Point(1, 3);
    return new Point[]{firstPoint, secondPoint, thirdPoint};
  }

  private Point[] getPointsForFirstLengthOfRectangle() {
    Point firstPoint = new Point(2, 5);
    Point secondPoint = new Point(3, 5);
    Point thirdPoint = new Point(4, 5);
    Point fourthPoint = new Point(5, 5);
    return new Point[]{firstPoint, secondPoint, thirdPoint, fourthPoint};
  }

  private Point[] getPointsForSecondLengthOfRectangle() {
    Point firstPoint = new Point(2, 4);
    Point secondPoint = new Point(3, 4);
    Point thirdPoint = new Point(4, 4);
    Point fourthPoint = new Point(5, 4);
    return new Point[]{firstPoint, secondPoint, thirdPoint, fourthPoint};
  }
    private Point[] getPointsForFirstWidthOfRectangle () {
      Point firstPoint = new Point(2, 4);
      Point secondPoint = new Point(2, 5);
      return new Point[]{firstPoint, secondPoint};
    }

    private Point[] getPointsForSecondWidthOfRectangle () {
      Point firstPoint = new Point(5, 4);
      Point secondPoint = new Point(5, 5);
      return new Point[]{firstPoint, secondPoint};
    }

    private Line[] getLinesForRectangle () {
      Line firstLine = new Line(getPointsForFirstLengthOfRectangle());
      Line secondLine = new Line(getPointsForSecondLengthOfRectangle());
      Line thirdLine = new Line(getPointsForFirstWidthOfRectangle());
      Line fourthLine = new Line(getPointsForSecondWidthOfRectangle());
      return new Line[]{firstLine, secondLine, thirdLine, fourthLine};
    }

    private Point getCenterOfCircle () {
      return new Point(3, 3);
    }

    private Point[] getPointsForRadius () {
      Point firstPoint = getCenterOfCircle();
      Point secondPoint = new Point(4, 3);
      Point thirdPoint = new Point(5, 3);
      Point fourthPoint = new Point(6, 3);
      return new Point[]{firstPoint, secondPoint, thirdPoint, fourthPoint};
    }

    private Line getRadiusOfCircle () {
      return new Line(getPointsForRadius());
    }

    private int getXCoordinate () {
      return 2;
    }

    private int getYCoordinate () {
      return 3;
    }

    public Shape[] createShapeArray () {
      return new Shape[]{new Point(getXCoordinate(), getYCoordinate()),
          new Line(getPointsForLine()),
          new Rectangle(getLinesForRectangle()),
          new Circle(getCenterOfCircle(), getRadiusOfCircle())};
    }

    public static void main (String[]args){
      Main main = new Main();
      GraphicalObjectEditor graphicalObjectEditor = new GraphicalObjectEditor();
      graphicalObjectEditor.addShapesToCanvas(main.createShapeArray());
      graphicalObjectEditor.render();
    }
  }
