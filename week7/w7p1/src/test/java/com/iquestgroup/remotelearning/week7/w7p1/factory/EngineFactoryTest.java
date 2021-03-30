package com.iquestgroup.remotelearning.week7.w7p1.factory;

import com.iquestgroup.remotelearning.week7.w7p1.domain.Employee;
import com.iquestgroup.remotelearning.week7.w7p1.domain.Engine;
import com.iquestgroup.remotelearning.week7.w7p1.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.week7.w7p1.domain.EngineComponent;
import com.iquestgroup.remotelearning.week7.w7p1.exception.InsufficientStockException;
import com.iquestgroup.remotelearning.week7.w7p1.exception.UnauthorizedEmployeeException;
import com.iquestgroup.remotelearning.week7.w7p1.exception.UnqualifiedEmployeeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EngineFactoryTest {

  public static final Employee UNAUTHORIZED_EMPLOYEE;
  public static final Employee UNQUALIFIED_EMPLOYEE;
  public static final Employee VALID_EMPLOYEE;
  public static final Engine ENGINE;
  public static final int VALID_NUMBER_OF_ENGINES;
  public static final int INVALID_NUMBER_OF_ENGINES;
  public static final int VALID_NO_OF_COMPONENTS_PER_ENGINE;
  public static final List<EngineComponent> EMPTY_LIST;

  static {
    UNAUTHORIZED_EMPLOYEE = new Employee("Ionel", true, true);
    UNQUALIFIED_EMPLOYEE = new Employee("Mircea", true, false);
    VALID_EMPLOYEE = new Employee("Aurel", true, true);
    ENGINE = new Engine(EngineArchitecture.L4, 2.0, 210);
    VALID_NUMBER_OF_ENGINES = 1;
    INVALID_NUMBER_OF_ENGINES = 2;
    VALID_NO_OF_COMPONENTS_PER_ENGINE = 3;
    EMPTY_LIST = new ArrayList<>();
  }

  private List<Employee> employees;
  private EngineFactory engineFactory;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testGetComponentsPerEngine() {
    int actualResult = EngineFactory.getComponentsPerEngine();
    String assertMessage = "There are no " + VALID_NO_OF_COMPONENTS_PER_ENGINE + " components per engine.";
    assertEquals(assertMessage, VALID_NO_OF_COMPONENTS_PER_ENGINE, actualResult);
  }

  @Test(expected = UnauthorizedEmployeeException.class)
  public void testManufactureEnginesUnauthorizedEmployee() {
    engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, UNAUTHORIZED_EMPLOYEE);
  }

  @Test(expected = UnqualifiedEmployeeException.class)
  public void testManufactureEnginesUnqualifiedEmployee() {
    engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, UNQUALIFIED_EMPLOYEE);
  }

  @Test(expected = InsufficientStockException.class)
  public void testManufactureEnginesInvalidNumberOfEngines() {
    engineFactory.manufactureEngines(INVALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE);
  }

  @Test(expected = InsufficientStockException.class)
  public void testManufactureEnginesNullEngineComponents() {
    engineFactory = new EngineFactory(employees, null);
    engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE);
  }

  @Test(expected = InsufficientStockException.class)
  public void testManufactureEnginesEmptyEngineComponents() {
    engineFactory = new EngineFactory(employees, EMPTY_LIST);
    engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE);
  }

  @Test
  public void testManufactureEngines() {
    List<Engine> expectedEngines = getExpectedEngines();
    List<Engine> actualEngines = engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE);
    int expectedSize = expectedEngines.size();
    int actualSize = actualEngines.size();
    String assertMessageDifferentSizes = "The size is not " + VALID_NUMBER_OF_ENGINES + ".";
    assertEquals(assertMessageDifferentSizes, expectedSize, actualSize);
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

  private List<Engine> getExpectedEngines() {
    List<Engine> expectedEngines = new ArrayList<>();
    for (int i = 0; i < VALID_NUMBER_OF_ENGINES; i++) {
      expectedEngines.add(ENGINE);
    }
    return expectedEngines;
  }

  private void initData() {
    employees = new ArrayList<>(Arrays.asList(UNQUALIFIED_EMPLOYEE, VALID_EMPLOYEE));
    EngineComponent engineComponent1 = new EngineComponent("eng1", 22.2);
    EngineComponent engineComponent2 = new EngineComponent("eng2", 28.9);
    EngineComponent engineComponent3 = new EngineComponent("eng3", 34.3);
    List<EngineComponent> engineComponents = new ArrayList<>();
    engineComponents.add(engineComponent1);
    engineComponents.add(engineComponent2);
    engineComponents.add(engineComponent3);
    engineFactory = new EngineFactory(employees, engineComponents);
  }
}
