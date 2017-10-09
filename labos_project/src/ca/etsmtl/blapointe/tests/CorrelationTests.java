// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe.tests;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.etsmtl.blapointe.IO;

/**
 * @author benoit
 * 
 */
public class CorrelationTests {

  private BufferedReader reader;
  private double[][] values;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    reader = IO.getReader("csv_tests/correlation/correlation_lb.csv");
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
   * {@link ca.etsmtl.blapointe.apps.CorrelationApps#main(java.lang.String[])}.
   * 
   * @throws IOException
   * @throws NumberFormatException
   */
  @Test
  public void testCorrelationLowerBoundary() {
    fail("Not implemented yet");
  }

  /**
   * Test method for
   * {@link ca.etsmtl.blapointe.apps.CorrelationApps#main(java.lang.String[])}.
   * 
   * @throws IOException
   * @throws NumberFormatException
   */
  @Test
  public void testCorrelationUpperBoundary() {
    fail("Not implemented yet");
  }

  /**
   * Test method for
   * {@link ca.etsmtl.blapointe.apps.CorrelationApps#main(java.lang.String[])}.
   * 
   * @throws IOException
   */
  @Test
  public void testCorrelationError() {
    fail("Not implemented yet");
  }
}
