package com.iquestgroup.remotelearning.week6.w6p3;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.iquestgroup.remotelearning.week6.w6p3.models.MyClass;
import com.iquestgroup.remotelearning.week6.w6p3.models.MyClassFactory;
import com.iquestgroup.remotelearning.week6.w6p3.models.MyClassType;
import org.junit.Before;
import org.junit.Test;

public class MyClassFactoryTest {

  private MyClassFactory myClassFactory;

  @Before
  public void setUp() {
    myClassFactory = new MyClassFactory();
  }

  @Test
  public void testGetMyClassInternal()
      throws IllegalAccessException, ClassNotFoundException, InstantiationException {
    MyClass currentMyClass = myClassFactory.getMyClass(MyClassType.INITIAL);
    assertThat(currentMyClass.getString(), is("Internal Java Class"));
  }

  @Test(expected = ClassCastException.class)
  public void testGetMyClassExternal()
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    myClassFactory.getMyClass(MyClassType.RELOADED);
  }

  @Test
  public void testGetMySubclassReloaded()
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    MyClass currentMyClass = myClassFactory.getMyClass(MyClassType.RELOADED_SUBCLASS);
    assertThat(currentMyClass.getString(), is("External Java Subclass"));
  }
}
