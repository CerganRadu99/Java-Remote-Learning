package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;
import java.util.Random;

public class Drummer implements Singer {

  private final List<Drumset> drumsets;

  public Drummer(List<Drumset> drumsets) {
    this.drumsets = drumsets;
  }

  @Override
  public void sing() {
    Random random = new Random();
    drumsets.get(random.nextInt(drumsets.size())).play();
    System.out.println("Drummer is singing...");
  }
}
