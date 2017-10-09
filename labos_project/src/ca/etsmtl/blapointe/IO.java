// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that handle io operations.
 * 
 * @author benoit
 * 
 */
public class IO {

  private static final String SEPARATOR_COMA = ",";
  private static final String SEPARATOR_SEMICOLON = ";";

  /**
   * Check parameters to read file from commandline.
   * 
   * @param args
   *          - a file name as argument
   * @param n
   */
  public static void checkParams(String[] args, String[] argsEx) {
    if (args.length != argsEx.length - 1) {
      String msg = (argsEx.length - 1) + " argument(s) est(sont) requis:\n"
          + "   - exemple de commande 'java -jar ";
      for (int i = 0; i < argsEx.length; i++) {
        msg += argsEx[i] + " ";
      }
      msg += "\"'";
      throw new IllegalArgumentException(msg);
    }
  }

  /**
   * Read a csv file (only the first line).
   * 
   * @param fileName
   *          - the name of the file
   * @return a reader that use a buffer
   * @throws FileNotFoundException
   */
  public static BufferedReader getReader(String fileName)
      throws FileNotFoundException {
    return new BufferedReader(new FileReader(fileName));
  }

  /**
   * Read a csv file (only the first line).
   * 
   * @param fileName
   *          - the name of the file
   * @return a table of int got from the file.
   * @throws IOException
   * @throws NumberFormatException
   */
  public static double[] readCsv(BufferedReader reader)
      throws NumberFormatException, IOException {
    // init variables
    int i = 0;
    double[] values = null;
    String line = null;

    // lire la premiere ligne
    if ((line = reader.readLine()) != null) {
      values = new double[line.split(SEPARATOR_COMA).length];
      // boucle sur la ligne pour obtenir les valeurs entiere
      for (String num : line.split(SEPARATOR_COMA)) {
        values[i++] = Double.parseDouble(num.trim());
      }
    }
    return values;
  }

  /**
   * Read a csv file that contains values couples.
   * 
   * @param reader
   *          - a file buffered reader
   * @return 2d array with values couples
   * @throws IOException
   * @throws NumberFormatException
   */
  public static double[][] readCsvPairs(BufferedReader reader)
      throws IOException {
    // init variables
    int n = 0;
    String line = null;
    String[] pair = new String[2];
    if ((line = reader.readLine()) != null) { // lire la premiere ligne
      n = Integer.parseInt(line.split(SEPARATOR_SEMICOLON)[0]); // n=firstline
    }
    double[][] results = new double[2][n];

    // read line by line
    for (int i = 0; i < n; i++) { // validate pair list size with n
      line = reader.readLine();
      if (line != null) {
        pair = line.split(SEPARATOR_SEMICOLON); // Pair = parse line
        results[0][i] = Double.parseDouble(pair[0].trim().replace(",", "."));
        results[1][i] = Double.parseDouble(pair[1].trim().replace(",", "."));
      }
    }
    return results; // return pair list
  }
}
