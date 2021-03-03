package com.iquestgroup.remotelearning.week3.p2;

import com.iquestgroup.remotelearning.week3.p2.models.Amphibian;
import com.iquestgroup.remotelearning.week3.p2.models.Frog;
import com.iquestgroup.remotelearning.week3.p2.models.Skin;

public class Main {

  public static void main(String[] args) {
    Frog frog = new Frog("green", new Skin());
    Amphibian amphibian = frog;
    amphibian.breathe();
    amphibian.eat();
    amphibian.swim();
    amphibian.hibernate();
  }
}
