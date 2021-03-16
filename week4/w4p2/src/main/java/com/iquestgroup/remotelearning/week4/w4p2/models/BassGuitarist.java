package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;
import java.util.Random;

public class BassGuitarist extends Guitarist {

  public BassGuitarist(List<Guitar> guitars) {
    super(guitars);
  }

  @Override
  public void sing() {
    Random random = new Random();
    getGuitars().get(random.nextInt(getGuitars().size())).play();
    System.out.println("Bass guitarist is singing...");
  }
}
