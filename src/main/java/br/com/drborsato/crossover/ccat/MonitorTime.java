package br.com.drborsato.crossover.ccat;

import static java.lang.Thread.sleep;

/**
 * Author: Daniel Borsato Date: 6/28/19
 */
public class MonitorTime {

  public static void main(String[] args) {
    final int FIFTEEN_MINUTES_IN_SECONDS = 15*60;
    int time = 0;

    do {
      try {
        sleep(999);
        time++;
        if (time % 18 == 0) {
          int numberOfQuestion = time / 18;
          System.out.println("QUESTION ENDED: " + numberOfQuestion);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (time < FIFTEEN_MINUTES_IN_SECONDS);
  }

}
