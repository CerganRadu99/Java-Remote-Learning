package com.iquestgroup.remotelearning.week4.w4p1;

import com.iquestgroup.remotelearning.week4.w4p1.models.DispatchOperator;
import com.iquestgroup.remotelearning.week4.w4p1.models.Dispatcher;
import com.iquestgroup.remotelearning.week4.w4p1.models.Driver;
import com.iquestgroup.remotelearning.week4.w4p1.models.TaxiDriver;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Driver> drivers = new ArrayList<>();
    drivers.add(new TaxiDriver("Vlad"));
    Dispatcher operator = new DispatchOperator("Dan", drivers);

    operator.dispatch("Calea Motilor nr. 6");
  }
}
