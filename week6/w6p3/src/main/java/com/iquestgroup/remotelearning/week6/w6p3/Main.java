package com.iquestgroup.remotelearning.week6.w6p3;

import com.iquestgroup.remotelearning.week6.w6p3.models.MyClass;
import com.iquestgroup.remotelearning.week6.w6p3.models.MyClassFactory;


public class Main {

  public static void main(String[] args)
      throws IllegalAccessException, ClassNotFoundException, InstantiationException {

    MyClassFactory myClassFactory = new MyClassFactory();
    //Casting reloaded class object to the old class
    MyClass obj = (MyClass) myClassFactory
        .getMyClass("com.iquestgroup.week6.p3.MyClass");
    System.out.println(obj.getString());

  }
}
