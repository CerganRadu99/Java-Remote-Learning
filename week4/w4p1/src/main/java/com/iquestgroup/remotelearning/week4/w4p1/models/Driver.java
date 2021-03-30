package com.iquestgroup.remotelearning.week4.w4p1.models;

public interface Driver extends Person {

  String getCurrentLocation();

  int goToAddress(String address);
}
