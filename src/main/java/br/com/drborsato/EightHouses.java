package br.com.drborsato;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel Borsato Date: 8/15/19
 */
public class EightHouses {

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public List<Integer> cellCompete(int[] states, int days) {
    int[] nextDay = new int[states.length];
    for (int j = 0; j < days; j++) {
      int rightNeighbor = 0;
      int leftNeighbor = 0;
      for (int i = 0; i < states.length; i++) {
        if (i == 0) {
          rightNeighbor = states[i + 1];
          leftNeighbor = 0;
        } else if (i == states.length - 1) {
          rightNeighbor = 0;
          leftNeighbor = states[i - 1];
        } else {
          rightNeighbor = states[i + 1];
          leftNeighbor = states[i - 1];
        }
        if (leftNeighbor == rightNeighbor) {
          nextDay[i] = 0;
        } else {
          nextDay[i] = 1;
        }
      }
      states = nextDay;
    }
    List<Integer> myStates = new ArrayList<>();
    for (int i = 0; i < states.length; i++) {
      myStates.add(states[i]);
    }
    return myStates;
  }
  // METHOD SIGNATURE ENDS
}
