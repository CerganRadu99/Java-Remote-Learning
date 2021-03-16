package com.iquestgroup.remotelearning.week6.w6p2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ProxiScientificCalculator implements Calculator {

  private final Calculator calculator;

  public ProxiScientificCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  @Override
  public int add(int firstNumber, int secondNumber) {
    if (isClassAnnotated() || isMethodAnnotated("add")) {
      logInformation("add");
    }
    return calculator.add(firstNumber, secondNumber);
  }

  @Override
  public int sub(int firstNumber, int secondNumber) {
    if (isClassAnnotated() || isMethodAnnotated("sub")) {
      logInformation("sub");
    }
    return calculator.sub(firstNumber, secondNumber);
  }

  @Override
  public int multiply(int firstNumber, int secondNumber) {
    if (isClassAnnotated() || isMethodAnnotated("multiply")) {
      logInformation("multiply");
    }
    return calculator.multiply(firstNumber, secondNumber);
  }

  private boolean isMethodAnnotated(String methodName) {
    Method[] methods = calculator.getClass().getDeclaredMethods();
    for (Method method : methods) {
      if (method.getName().equals(methodName)) {
        Logged annotation = method.getAnnotation(Logged.class);
        if (annotation != null) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isClassAnnotated() {
    Annotation annotation = calculator.getClass().getAnnotation(Logged.class);
    return annotation != null;
  }

  private void logInformation(String methodName) {
    Class obj = calculator.getClass();
    System.out.println("----------OBJECT INFORMATIONS---------");
    System.out.println("Simple name: " + obj.getSimpleName());
    System.out.println("Canonical name: " + obj.getCanonicalName());
    System.out.println("Is interface : " + obj.isInterface());
    System.out.println("Package name: " + obj.getPackage().getName());
    Field[] fields = obj.getDeclaredFields();
    for (Field field : fields) {
      System.out.println(
          new StringBuilder().append(field.getName()).append(" ").append(field.getType())
              .toString());
    }
    System.out.println("----------METHOD INFORMATIONS---------");
    Method[] methods = obj.getDeclaredMethods();
    for (Method method : methods) {
      if (method.getName().equals(methodName)) {
        System.out.println("Method name: " + method.getName());
        System.out.println("Return type: " + method.getReturnType());
        for (Class parameterType : method.getParameterTypes()) {
          System.out.println("Parameter type: " + parameterType.getName());
        }
      }
    }
  }
}
