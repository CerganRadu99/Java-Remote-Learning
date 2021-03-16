package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;
import java.util.Random;

public class RhythmGuitarist extends Guitarist {

  public RhythmGuitarist(List<Guitar> guitars) {
    super(guitars);
  }

  @Override
  public void sing() {
    Random random = new Random();
    getGuitars().get(random.nextInt(getGuitars().size())).play();
    System.out.println("Rhythm guitarist is singing...");
  }
}
