package com.iquestgroup.remotelearning.week3.w3p2;

import com.iquestgroup.remotelearning.week3.w3p2.models.Amphibian;
import com.iquestgroup.remotelearning.week3.w3p2.models.Frog;
import com.iquestgroup.remotelearning.week3.w3p2.models.Skin;

public class Main {

  public static void main(String[] args) {
    //Upcasting
    Amphibian amphibian = new Frog("green", new Skin());
    amphibian.breathe();
    amphibian.eat();
    amphibian.swim();
    amphibian.hibernate();

    System.out.println("--------------------------------------------------");

    //Downcasting
    Frog frog = new Frog("grey", new Skin());
    Amphibian amphibian2 = frog;
    amphibian2.breathe();
    amphibian2.eat();
    amphibian2.swim();
    amphibian2.hibernate();

  }
}
