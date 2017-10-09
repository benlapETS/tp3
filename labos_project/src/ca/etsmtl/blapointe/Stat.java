// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe;

/**
 * Classe utilitaire de calcul statistiques.
 * 
 * @author benoit
 */
public class Stat {

  /**
   * Calcule la moyenne a partir d'un tableau de doubles.
   * 
   * @param values
   *          - un tableau de double
   * @return la moyenne calculee
   */
  public static double moyenne(double[] values) {
    double result = 0;
    for (double val : values) {
      result += val;
    }
    return result / values.length;
  }

  /**
   * Calcule la variance a partir de doubles tout en calculant la moyenne.
   * 
   * @param values
   *          - un tableau de doubles
   * @return la variance calculee
   */
  public static double variance(double[] values) {
    double moy = moyenne(values);
    return MathLib.sommeDistancesCarres(values, values, moy, moy)
        / (values.length - 1);
  }

  /**
   * Calcule la corrélation entre les variables aléatoires x,y d'un échantillon.
   * 
   * @param x
   *          - le vecteur échantillon x
   * @param y
   *          - le vecteur échantillon y
   * @return le coefficient de corrélation entre les couple d'échantillon x,y
   */
  public static double correlation(double[] x, double[] y) {
    double xM = moyenne(x);
    double yM = moyenne(y);
    return MathLib.sommeDistancesCarres(x, y, xM, yM)
        / Math.sqrt(MathLib.sommeDistancesCarres(x, x, xM, xM)
            * MathLib.sommeDistancesCarres(y, y, yM, yM));
  }

  /**
   * Calculate the standard deviation for values.
   * 
   * @param values
   *          - the input values
   * @return the standard deviation
   */
  public static double ecartType(double[] values) {
    return Math.sqrt(variance(values));
  }

}
