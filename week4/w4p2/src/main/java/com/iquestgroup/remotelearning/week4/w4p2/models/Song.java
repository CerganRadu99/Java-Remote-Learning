package com.iquestgroup.remotelearning.week4.w4p2.models;


public class Song implements Music {

  private final String name;
  private final double duration;
  private boolean isStopped;

  public Song(String name, double duration) {
    this.name = name;
    this.duration = duration;
    isStopped = true;
  }

  public boolean isStopped() {
    return isStopped;
  }

  @Override
  public void play() {
    isStopped = false;
    System.out.println("Song " + name + " starts and has a duration of " + duration + " minutes!");
  }

  @Override
  public void stop() {
    isStopped = true;
    System.out.println("Song " + name + " has stopped!");
  }
}
