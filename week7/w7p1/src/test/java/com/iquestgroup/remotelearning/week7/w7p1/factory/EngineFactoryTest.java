package com.iquestgroup.remotelearning.week7.w7p1.factory;

import com.iquestgroup.remotelearning.week7.w7p1.domain.Employee;
import com.iquestgroup.remotelearning.week7.w7p1.domain.EngineComponent;
import com.iquestgroup.remotelearning.week7.w7p1.exception.InsufficientStockException;
import com.iquestgroup.remotelearning.week7.w7p1.exception.UnauthorizedEmployeeException;
import com.iquestgroup.remotelearning.week7.w7p1.exception.UnqualifiedEmployeeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EngineFactoryTest {

  public static final Employee UNAUTHORIZED_EMPLOYEE = new Employee("Ionel", true, true);
  public static final Employee UNQUALIFIED_EMPLOYEE = new Employee("Mircea", true, false);
  public static final Employee VALID_EMPLOYEE = new Employee("Aurel", true, true);
  public static final int VALID_NUMBER_OF_ENGINES = 1;
  public static final int INVALID_NUMBER_OF_ENGINES = 2;
  public static final int VALID_NO_OF_COMPONENTS_PER_ENGINE = 3;
  public static final List<Employee> EMPLOYEES = new ArrayList<>(
      Arrays.asList(
          UNQUALIFIED_EMPLOYEE, VALID_EMPLOYEE));
  public static final List<EngineComponent> ENGINE_COMPONENTS = new ArrayList<>(Arrays
      .asList(new EngineComponent("eng1", 22.2), new EngineComponent("eng2", 31.5),
          new EngineComponent("eng3", 40.00)));
  public static final List<EngineComponent> EMPTY_LIST = new ArrayList<>();

  private EngineFactory engineFactory;

  @Before
  public void setup() {
    engineFactory = new EngineFactory(EMPLOYEES, ENGINE_COMPONENTS);
  }

  @After
  public void teardown() {
    //cleanup database
    //delete temporary files
    //etc.
  }

  @Test
  public void testGetComponentsPerEngine() {
    assertEquals("There are no " + VALID_NO_OF_COMPONENTS_PER_ENGINE + " components per engine",
        VALID_NO_OF_COMPONENTS_PER_ENGINE, EngineFactory.getComponentsPerEngine());
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
    engineFactory = new EngineFactory(EMPLOYEES, null);
    engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE);
  }

  @Test(expected = InsufficientStockException.class)
  public void testManufactureEnginesEmptyEngineComponents() {
    engineFactory = new EngineFactory(EMPLOYEES, EMPTY_LIST);
    engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE);
  }

  @Test
  public void testManufactureEngines() {
    assertEquals("The size is not " + VALID_NUMBER_OF_ENGINES,
        VALID_NUMBER_OF_ENGINES,
        engineFactory.manufactureEngines(VALID_NUMBER_OF_ENGINES, VALID_EMPLOYEE).size());
  }

  @BeforeClass
  public static void oneTimeSetup() {

  }

  @AfterClass
  public static void oneTimeTearDown() {

  }
}
