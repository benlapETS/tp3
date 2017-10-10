package ca.etsmtl.blapointe.tests;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.etsmtl.blapointe.IO;

/**
 * @author benoit
 * 
 */
public class VarianceTests {

  private BufferedReader reader;
  private double[][] values;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    reader = IO.getReader("csv_tests/variance/variance_lb.csv");
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    reader.close();
  }

  /**
   * Test method for
   * {@link ca.etsmtl.blapointe.apps.VarianceApps#main(java.lang.String[])}.
   * 
   */
  @Test
  public void testVarianceLowerBoundary() {
    assertTrue("Not implemented yet", true);
  }

  /**
   * Test method for
   * {@link ca.etsmtl.blapointe.apps.VarianceApps#main(java.lang.String[])}.
   * 
   */
  @Test
  public void testVarianceUpperBoundary() {
    assertTrue("Not implemented yet", true);
  }

  /**
   * Test method for
   * {@link ca.etsmtl.blapointe.apps.VarianceApps#main(java.lang.String[])}.
   * 
   */
  @Test
  public void testVarianceError() {
    assertTrue("Not implemented yet", true);
  }
}
