package com.iquestgroup.remotelearning.week6.w6p2.models;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

  public ProxyFactory() {
  }

  public Object createProxy(ClassLoader classLoader, Class[] interfaces,
      InvocationHandler handler) {
    return Proxy.newProxyInstance(classLoader, interfaces, handler);
  }
}
