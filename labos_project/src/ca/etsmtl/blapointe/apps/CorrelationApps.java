// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe.apps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import ca.etsmtl.blapointe.IO;
import ca.etsmtl.blapointe.MathLib;
import ca.etsmtl.blapointe.Stat;

/**
 * Correlation main apps class.
 * 
 * @author benoit
 */
public class CorrelationApps {
  private static String[] argsEx = { "correlation.jar ", "correlation.csv" };

  /**
   * Main thread that calculate correlation.
   * 
   * @param args
   *          - the file name to read
   */
  public static void main(String[] args) {
    // On valide les paramètres
    IO.checkParams(args, argsEx);

    // On ouvre le reader
    String fileName = args[0];
    BufferedReader reader = null;
    try {
      reader = IO.getReader(fileName);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException(e);
    }

    // On lit les valeurs
    double[][] values = {};
    try {
      values = IO.readCsvPairs(reader);
    } catch (NumberFormatException | IOException e) {
      throw new IllegalArgumentException(e);
    } finally {
      try {
        reader.close();
      } catch (IOException e) {
        throw new IllegalArgumentException(e);
      }
    }

    // On calcule les résultats
    double corr = Stat.correlation(values[0], values[1]);
    double[] xX = MathLib.mult(values[0], values[0]);
    double[] xY = MathLib.mult(values[0], values[1]);
    double[] yY = MathLib.mult(values[1], values[1]);

    // On affiche les résultats
    System.out
        .format("%5s %5s %10s %10s %10s\n", "x", "y", "x*x", "x*y", "y*y");
    for (int i = 0; i < values[0].length; i++) {
      System.out.format("%5.0f %5.1f %10.0f %10.1f %10.2f\n", values[0][i],
          values[1][i], xX[i], xY[i], yY[i]);
    }
    System.out.format("%5.0f %5.1f\n", MathLib.somme(values[0]),
        MathLib.somme(values[1]));
    System.out.format("%12s %1.8f\n", "r=", corr);
    System.out.format("%12s %1.8f\n", "r au carré=", (corr * corr));
  }
}
