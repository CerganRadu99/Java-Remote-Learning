package com.iquestgroup.remotelearning.week3.p2.models;

public class Frog extends Amphibian {

  private String color;

  public Frog(String color, Skin skin) {
    super(skin);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
