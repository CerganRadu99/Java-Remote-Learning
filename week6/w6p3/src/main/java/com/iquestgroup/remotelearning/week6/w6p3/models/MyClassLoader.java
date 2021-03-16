package com.iquestgroup.remotelearning.week6.w6p3.models;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyClassLoader extends ClassLoader {

  private static final String EXTERNAL_CLASS_CANONICAL_NAME = "com.iquestgroup.week6.p3.MyClass";
  private static final String EXTERNAL_CLASS_PATH = "file:C:\\Users\\cerga\\IntellijUltimateWorkspace\\test\\java-test-loader\\src\\com\\iquestgroup\\week6\\p3\\MyClass.class";

  public MyClassLoader(ClassLoader parent) {
    super(parent);
  }

  public Class loadClass(String name) throws ClassNotFoundException {
    if (!EXTERNAL_CLASS_CANONICAL_NAME.equals(name)) {
      return super.loadClass(name);
    }

    try {
      String url = EXTERNAL_CLASS_PATH;
      URL myUrl = new URL(url);
      URLConnection connection = myUrl.openConnection();
      InputStream input = connection.getInputStream();
      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      int data = input.read();

      while (data != -1) {
        buffer.write(data);
        data = input.read();
      }

      input.close();

      byte[] classData = buffer.toByteArray();

      return defineClass(EXTERNAL_CLASS_CANONICAL_NAME,
          classData, 0, classData.length);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}