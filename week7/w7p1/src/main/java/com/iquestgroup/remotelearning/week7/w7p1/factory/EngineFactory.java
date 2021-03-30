package com.iquestgroup.remotelearning.week7.w7p1.factory;

import com.iquestgroup.remotelearning.week7.w7p1.domain.Employee;
import com.iquestgroup.remotelearning.week7.w7p1.domain.Engine;
import com.iquestgroup.remotelearning.week7.w7p1.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.week7.w7p1.domain.EngineComponent;
import com.iquestgroup.remotelearning.week7.w7p1.exception.InsufficientStockException;
import com.iquestgroup.remotelearning.week7.w7p1.exception.UnauthorizedEmployeeException;
import com.iquestgroup.remotelearning.week7.w7p1.exception.UnqualifiedEmployeeException;

import java.util.ArrayList;
import java.util.List;

public class EngineFactory {

  private static final int COMPONENTS_PER_ENGINE = 3;
  private List<Employee> employees;
  private List<EngineComponent> engineComponents;

  public EngineFactory(List<Employee> employees, List<EngineComponent> engineComponents) {
    this.employees = employees;
    this.engineComponents = engineComponents;
  }

  public static int getComponentsPerEngine() {
    return COMPONENTS_PER_ENGINE;
  }

  public List<Engine> manufactureEngines(int numberOfEngines, Employee assignedEmployee) {
    checkAssignedEmployee(assignedEmployee);
    if (enoughComponentsInStock(numberOfEngines)) {
      List<Engine> newEngines = new ArrayList<Engine>();
      for (int i = 0; i < numberOfEngines; i++) {
        newEngines.add(buildEngine());
      }
      return newEngines;
    } else {
      throw new InsufficientStockException("Not enough stock to build [" + numberOfEngines + "] engines!");
    }
  }

  /**
   * Makes sure that the employee assigned to manufacture the engines meets all the necessary conditions for this task.
   *
   * @param assignedEmployee the employee to check
   */
  private void checkAssignedEmployee(Employee assignedEmployee) {
    if (!employees.contains(assignedEmployee)) {
      throw new UnauthorizedEmployeeException("Employee [" + assignedEmployee.getName() + "]is not authorized to work at this factory!");
    }
    if (!assignedEmployee.isAssemblyLineWorker()) {
      throw new UnqualifiedEmployeeException("Employee [" + assignedEmployee.getName() + "] is not qualified to build engines!");
    }
  }

  /**
   * Builds a new engine, taking the needed number of component from the stock.
   *
   * @return a brand new engine
   */
  private Engine buildEngine() {
    for (int i = 0; i < COMPONENTS_PER_ENGINE; i++) {
      engineComponents.remove(0);
    }
    //for 1 extra point - randomize the engine types manufactured
    return new Engine(EngineArchitecture.L4, 2.0, 210);
  }

  /**
   * Determines if there are enough engine components in stock to build the required number of engines.
   *
   * @param numberOfEnginesToBuild the number of engines we have to build
   * @return true if we have enough components in stock, false otherwise
   */
  private boolean enoughComponentsInStock(int numberOfEnginesToBuild) {
    if (engineComponents == null || engineComponents.isEmpty()) {
      return false;
    }
    int nrOfEngineComponentsNeeded = numberOfEnginesToBuild * COMPONENTS_PER_ENGINE;
    int nrOfEngineComponentsInStock = engineComponents.size();
    return nrOfEngineComponentsInStock >= nrOfEngineComponentsNeeded;
  }
}

