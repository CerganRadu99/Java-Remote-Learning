package com.iquestgroup.remotelearning.week6.w6p2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ScientificCalculatorHandler implements InvocationHandler {

  private final Calculator calculator;

  public ScientificCalculatorHandler(Calculator calculator) {
    this.calculator = calculator;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if(isClassAnnotated() || isMethodAnnotated(method)){
      Class calculatorClass = calculator.getClass();
      System.out.println("Name: " + calculatorClass.getName());
      System.out.println("Simple name: " + calculatorClass.getSimpleName());
      System.out.println("Is interface? " + calculatorClass.isInterface());
      System.out.println("Is annotation? " + calculatorClass.isAnnotation());
      System.out.println("Method " + method.getName() + " has return type: " + method.getReturnType() + " and has " + args.length + " parameters of type:");
      for(Object parameter : args){
        System.out.println(parameter.getClass());
      }
    }
    return method.invoke(calculator, args);
  }
  private boolean isMethodAnnotated(Method method){
    Class calculatorClass = calculator.getClass();
    for(Method currentMethod : calculatorClass.getMethods()){
      if(currentMethod.getName().equals(method.getName())){
        if(currentMethod.isAnnotationPresent(Logged.class)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isClassAnnotated(){
    Class calculatorClass = calculator.getClass();
    return calculatorClass.isAnnotationPresent(Logged.class);
  }
}
