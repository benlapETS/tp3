// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe.apps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import ca.etsmtl.blapointe.IO;
import ca.etsmtl.blapointe.Stat;

/**
 * Variance main app class.
 * 
 * @author benoit
 */
public class VarianceApps {
  private static String[] argsEx = { "variance.jar ", "variance.csv" };

  /**
   * Main application that calculate variance.
   * 
   * @param args
   *          - a file name as first argument
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
    double[] values = {};
    try {
      values = IO.readCsv(reader);
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
    double moyenne = Stat.moyenne(values);
    double variance = Stat.variance(values);
    double ecartType = Stat.ecartType(values);

    // On affiche les résultats
    System.out.println("La moyenne est: " + moyenne);
    System.out.println("La variance est: " + variance);
    System.out.println("L'ecart-type est: " + ecartType);
  }
}
