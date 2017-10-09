// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe;

/**
 * Classe utilitaire de calculs mathématiques divers.
 * 
 * @author benoit
 */
public class MathLib {

  /**
   * Calcule la somme des distance des valeurs avec la moyenne au carre.
   * 
   * @param x
   *          - un tableau de double
   * @param y
   *          - un tableau de double
   * @param xM
   *          - la moyenne des x
   * @param yM
   *          - la moyenne des y
   * @return la somme des distance au carre
   */
  public static double sommeDistancesCarres(double[] x, double[] y, double xM,
      double yM) {
    double result = 0;
    for (int i = 0; i < x.length; i++) {
      result += distanceCarre(x[i], y[i], xM, yM);
    }
    return result;
  }

  /**
   * Calcule la distance d'une valeur avec la moyenne au carre.
   * 
   * @param x
   *          - la valeur a calculer
   * @param y
   *          - la valeur a soustraire
   * @param xM
   *          - la moyenne de x
   * @param yM
   *          - la moyenne de y
   * @return la distance de la valeur
   */
  public static double distanceCarre(double x, double y, double xM, double yM) {
    return (x - xM) * (y - yM);
  }

  /**
   * Multiplie chaque couple x,y.
   * 
   * @param x
   *          - le vecteur x
   * @param y
   *          - le vecteur y
   * @return le vecteur x*y
   */
  public static double[] mult(double[] x, double[] y) {
    double[] result = new double[x.length];
    for (int i = 0; i < x.length; i++) {
      result[i] = x[i] * y[i];
    }
    return result;
  }

  /**
   * Additionne tous les éléments d'un vecteur entre eux.
   * 
   * @param x
   *          - le vecteur à additionner
   * @return la somme des éléments du vecteur x
   */
  public static double somme(double[] x) {
    double result = 0;
    for (double xi : x) {
      result += xi;
    }
    return result;
  }

}
