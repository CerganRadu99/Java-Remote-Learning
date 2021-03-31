package com.iquestgroup.remotelearning.week7.w7p2.factory;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week7.w7p2.domain.Employee;
import com.iquestgroup.remotelearning.week7.w7p2.domain.Engine;
import com.iquestgroup.remotelearning.week7.w7p2.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.week7.w7p2.exception.UnqualifiedEmployeeException;
import com.iquestgroup.remotelearning.week7.w7p2.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class EngineFactoryTest {

  public static final Employee QUALIFIED_EMPLOYEE;
  public static final Employee UNQUALIFIED_EMPLOYEE;
  public static final Engine ENGINE;
  public static final int NUMBER_OF_ENGINES;

  static {
    QUALIFIED_EMPLOYEE = new Employee("Mircea");
    UNQUALIFIED_EMPLOYEE = new Employee("Ionel");
    NUMBER_OF_ENGINES = 3;
    ENGINE = new Engine(EngineArchitecture.L4, 2.0, 210);
  }

  private EmployeeService employeeService;
  private EngineFactory engineFactory;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testManufactureEnginesQualifiedEmployee() {
    List<Engine> expectedEngines = getExpectedEngines();
    EasyMock.expect(employeeService.isAssemblyLineWorker(QUALIFIED_EMPLOYEE)).andReturn(true);
    EasyMock.replay(employeeService);
    List<Engine> actualEngines = engineFactory.manufactureEngines(NUMBER_OF_ENGINES, QUALIFIED_EMPLOYEE);
    EasyMock.verify(employeeService);
    int expectedSize = expectedEngines.size();
    int actualSize = actualEngines.size();
    assertEquals(expectedSize, actualSize);
    for (int index = 0; index < actualSize; index++) {
      EngineArchitecture expectedEngineArchitecture = expectedEngines.get(index).getEngineArchitecture();
      EngineArchitecture actualEngineArchitecture = actualEngines.get(index).getEngineArchitecture();
      double expectedDisplacement = expectedEngines.get(index).getDisplacement();
      double actualDisplacement = actualEngines.get(index).getDisplacement();
      int expectedHorsePower = expectedEngines.get(index).getHorsePower();
      int actualHorsePower = actualEngines.get(index).getHorsePower();
      assertEquals(expectedEngineArchitecture, actualEngineArchitecture);
      assertEquals(expectedDisplacement, actualDisplacement, 0);
      assertEquals(expectedHorsePower, actualHorsePower);
    }
  }

  @Test(expected = UnqualifiedEmployeeException.class)
  public void testManufactureEnginesUnqualifiedEmployee() {
    EasyMock.expect(employeeService.isAssemblyLineWorker(UNQUALIFIED_EMPLOYEE)).andReturn(false);
    EasyMock.replay(employeeService);
    engineFactory.manufactureEngines(NUMBER_OF_ENGINES, UNQUALIFIED_EMPLOYEE);
  }

  private List<Engine> getExpectedEngines() {
    List<Engine> expectedEngines = new ArrayList<>();
    for (int i = 0; i < NUMBER_OF_ENGINES; i++) {
      expectedEngines.add(ENGINE);
    }
    return expectedEngines;
  }

  private void initData() {
    if (employeeService == null) {
      employeeService = EasyMock.createMock(EmployeeService.class);
      engineFactory = new EngineFactory(employeeService);
    } else {
      EasyMock.reset(employeeService);
    }
  }
}
