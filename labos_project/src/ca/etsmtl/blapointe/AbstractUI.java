// Copyright ÉTS_ETE2016_LOG330-01_EQ13. All rights reserved.
// Toute réutilisation de ce code source est interdite et sera considérée
// comme une infraction au sens de la résolution CA-331-3487:
// - Règlement sur les infractions de nature académique.

package ca.etsmtl.blapointe;

import java.util.Scanner;

/**
 * Classe template d'interface utilisateur.
 * 
 * @author benoit
 */
public abstract class AbstractUI {
  protected String calculateActionString = "";

  /**
   * Méthode template qui lance l'interaction entre l'utilisateur et
   * l'application de calcul.
   */
  public void interact() {
    boolean quit = false;
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    String action = "";

    while (!quit) {
      action = menu(scan);
      calculateTestData();
      if (action.equalsIgnoreCase("T")) {
        printTestData();
      } else if (action.equalsIgnoreCase("C")) {
        calculate(scan2);
      } else if (action.equalsIgnoreCase("Q")) {
        quit = true;
      }
      System.out.println();
    }
    scan.close();
    scan2.close();
  }

  /**
   * Print data to the user to validate results.
   */
  protected abstract void printTestData();

  /**
   * Prepare test data.
   */
  protected abstract void calculateTestData();

  /**
   * Calculate the main purpose of this UI class.
   * 
   * @param scan2
   *          - the scanner to use for the main calculation
   */
  protected abstract void calculate(Scanner scan2);

  /**
   * Print menu and scan user choice.
   * 
   * @param scan
   *          - the scanner used to get user's choice
   * @return - the action the user chose
   */
  private String menu(Scanner scan) {
    System.out.print("Quelle action voulez-vous accomplir ? "
        + "\n(T) Tester les données\n" + "(C) " + calculateActionString
        + "\n(Q) Quitter\nChoix: ");
    String action = scan.next();
    scan.reset();
    return action;
  }
}
