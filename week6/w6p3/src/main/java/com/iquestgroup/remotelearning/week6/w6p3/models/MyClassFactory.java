package com.iquestgroup.remotelearning.week6.w6p3.models;

public class MyClassFactory {

  private static final String RELOADED_CLASS_CANONICAL_NAME = "com.iquestgroup.remotelearning.week6.w6p3.models.MyClass";
  private static final String RELOADED_SUBCLASS_CANONICAL_NAME = "com.iquestgroup.remotelearning.week6.w6p3.models.MySubclass";
  private static final MyClassType EXTERNAL_MY_CLASS = MyClassType.RELOADED;
  private static final MyClassType EXTERNAL_MY_SUBCLASS = MyClassType.RELOADED_SUBCLASS;
  private static final MyClassType INTERNAL_MY_CLASS = MyClassType.INITIAL;

  public MyClass getMyClass(MyClassType classType)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    MyClass object = null;
    if (classType == INTERNAL_MY_CLASS) {
      object = new MyClass();
    } else if (classType == EXTERNAL_MY_CLASS) {
      ClassLoader parentClassLoader = getClass().getClassLoader();
      MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
      Class myObjectClass = classLoader.loadClass(RELOADED_CLASS_CANONICAL_NAME);
      object = (MyClass) myObjectClass.newInstance();
    } else if (classType == EXTERNAL_MY_SUBCLASS) {
      ClassLoader parentClassLoader = getClass().getClassLoader();
      SubclassLoader classLoader = new SubclassLoader(parentClassLoader);
      Class myObjectClass = classLoader.loadClass(RELOADED_SUBCLASS_CANONICAL_NAME);
      object = (MyClass) myObjectClass.newInstance();
    }
    return object;
  }
}
