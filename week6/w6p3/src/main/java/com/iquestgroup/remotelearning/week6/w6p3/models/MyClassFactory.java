package com.iquestgroup.remotelearning.week6.w6p3.models;

public class MyClassFactory {

  private static final String RELOADED_CLASS_CANONICAL_NAME = "com.iquestgroup.week6.p3.MyClass";
  private static final String INITIAL_CLASS_CANONICAL_NAME = "com.iquestgroup.remotelearning.week6.w6p3.models.MyClass";

  public Object getMyClass(String className)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    Object obj = new Object();
    if (className.equals(INITIAL_CLASS_CANONICAL_NAME)) {
      obj = new MyClass();
    } else if (className.equals(RELOADED_CLASS_CANONICAL_NAME)) {
      ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
      MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
      Class myObjectClass = classLoader.loadClass(RELOADED_CLASS_CANONICAL_NAME);
      obj = myObjectClass.newInstance();
    }
    return obj;

  }

}
