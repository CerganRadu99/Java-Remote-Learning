package com.iquestgroup.remotelearning.week7.w7p2.factory;

import static org.junit.Assert.assertEquals;

import com.iquestgroup.remotelearning.week7.w7p2.domain.Employee;
import com.iquestgroup.remotelearning.week7.w7p2.domain.Engine;
import com.iquestgroup.remotelearning.week7.w7p2.exception.UnqualifiedEmployeeException;
import com.iquestgroup.remotelearning.week7.w7p2.service.EmployeeService;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class EngineFactoryTest {

  public static final Employee EMPLOYEE = new Employee("Mircea");
  public static final int NUMBER_OF_ENGINES = 3;

  private EmployeeService employeeService;
  private EngineFactory engineFactory;

  @Before
  public void setup() {
    if (employeeService == null) {
      employeeService = EasyMock.createMock(EmployeeService.class);
      engineFactory = new EngineFactory(employeeService);
    } else {
      EasyMock.reset(employeeService);
    }
  }

  @Test
  public void testManufactureEnginesQualifiedEmployee() {
    EasyMock.expect(employeeService.isAssemblyLineWorker(EMPLOYEE)).andReturn(true);
    EasyMock.replay(employeeService);
    List<Engine> result = engineFactory.manufactureEngines(NUMBER_OF_ENGINES, EMPLOYEE);
    EasyMock.verify(employeeService);
    assertEquals("The size is not " + NUMBER_OF_ENGINES, NUMBER_OF_ENGINES, result.size());
  }

  @Test(expected = UnqualifiedEmployeeException.class)
  public void testManufactureEnginesUnqualifiedEmployee() {
    EasyMock.expect(employeeService.isAssemblyLineWorker(EMPLOYEE)).andReturn(false);
    EasyMock.replay(employeeService);
    engineFactory.manufactureEngines(NUMBER_OF_ENGINES, EMPLOYEE);
    EasyMock.verify(employeeService);
  }
}
