package com.iquestgroup.remotelearning.week3.w3p2.models;

public class Amphibian {

  private Skin skin;

  public Amphibian(Skin skin) {
    this.skin = skin;
  }

  public void eat() {
    System.out.println("Amphibian is eating...");
  }

  public void swim() {
    System.out.println("Amphibian is swimming...");
  }

  public void hibernate() {
    System.out.println("Amphibian is hibernating...");
  }

  public void breathe() {
    System.out.println("Amphibian is breathing...");
  }
}