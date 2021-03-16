package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;
import java.util.Random;

public class LeadGuitarist extends Guitarist {

  public LeadGuitarist(List<Guitar> guitars) {
    super(guitars);
  }

  @Override
  public void sing() {
    Random random = new Random();
    getGuitars().get(random.nextInt(getGuitars().size())).play();
    System.out.println("Lead guitarist is singing...");
  }
}
