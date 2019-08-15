package br.com.drborsato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: Daniel Borsato Date: 8/15/19
 */
public class MinCostConnectRopes {


  /**
   * Given n ropes of different lengths, we need to connect these ropes into one rope. We
   * can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of
   * their lengths. The length of this connected rope is also equal to the sum of their lengths.
   * This process is repeated until n ropes are connected into a single rope. Find the min possible
   * cost required to connect all ropes.
   *
   * Example 1:
   *
   * Input: ropes = [8, 4, 6, 12] Output: 58 Explanation: The optimal way to connect ropes is as
   * follows 1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10,
   * 12] 2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12] 3.
   * Connect the ropes of length 18 and 12 (cost is 30). Total cost to connect the ropes is 10 + 18
   * + 30 = 58
   */
  public int minCost(int[] arr) {

    int minCost = 0;

    PriorityQueue<Integer> ropes = new PriorityQueue<>();
//    List<Integer> ropes = new ArrayList<>();

    for (int i = 0; i < arr.length; i ++) {
      ropes.add(arr[i]);
    }

    for (int i = 0; i < arr.length - 1; i ++) {
//      Collections.sort(ropes);

//      int thisCost = ropes.get(0);
//      ropes.remove(0);
      int thisCost = ropes.poll();

//      thisCost += ropes.get(0);
//      ropes.remove(0);
      thisCost += ropes.poll();

      ropes.add(thisCost);
      minCost += thisCost;
    }
    return minCost;
  }

}
