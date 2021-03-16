package com.iquestgroup.remotelearning.week4.w4p2.models;

import java.util.List;

public abstract class Guitarist implements Singer {

  private final List<Guitar> guitars;

  protected Guitarist(List<Guitar> guitars) {
    this.guitars = guitars;
  }

  public List<Guitar> getGuitars() {
    return guitars;
  }
}
