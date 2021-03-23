package com.iquestgroup.remotelearning.week6.w6p3;

import com.iquestgroup.remotelearning.week6.w6p3.models.MyClass;
import com.iquestgroup.remotelearning.week6.w6p3.models.MyClassFactory;
import com.iquestgroup.remotelearning.week6.w6p3.models.MyClassType;

public class Main {

  public static void main(String[] args)
      throws IllegalAccessException, ClassNotFoundException, InstantiationException {

    MyClassFactory myClassFactory = new MyClassFactory();

    //load initial class
    MyClass obj1 = myClassFactory.getMyClass(MyClassType.INITIAL);
    System.out.println(obj1);

    //Casting reloaded class object to the old class
    MyClass obj2 = (MyClass) myClassFactory
        .getMyClass(MyClassType.RELOADED);
    System.out.println(obj2.getString());

    // Casting subclass
    MyClass obj3 = myClassFactory
        .getMyClass(MyClassType.RELOADED_SUBCLASS);
    System.out.println(obj3);
  }
}
