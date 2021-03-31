package com.iquestgroup.remotelearning.week7.w7p2.factory;

import com.iquestgroup.remotelearning.week7.w7p2.service.EmployeeService;
import com.iquestgroup.remotelearning.week7.w7p2.domain.Employee;
import com.iquestgroup.remotelearning.week7.w7p2.domain.Engine;
import com.iquestgroup.remotelearning.week7.w7p2.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.week7.w7p2.exception.UnqualifiedEmployeeException;
import java.util.ArrayList;
import java.util.List;

public class EngineFactory {

  private EmployeeService employeeService;

  public EngineFactory(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  public List<Engine> manufactureEngines(int numberOfEngines, Employee assignedEmployee) {
    if (!employeeService.isAssemblyLineWorker(assignedEmployee)) {
      throw new UnqualifiedEmployeeException("Employee [" + assignedEmployee.getName() + "] is not qualified to build engines!");
    }

    List<Engine> newEngines = new ArrayList<Engine>();
    for (int i = 0; i < numberOfEngines; i++) {
      newEngines.add(new Engine(EngineArchitecture.L4, 2.0, 210));
    }
    return newEngines;
  }

}
