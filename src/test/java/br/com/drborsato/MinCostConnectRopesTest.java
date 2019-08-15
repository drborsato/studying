package br.com.drborsato;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Daniel Borsato Date: 8/15/19
 */
public class MinCostConnectRopesTest {

  private MinCostConnectRopes minCostConnectRopes = new MinCostConnectRopes();

  @Test
  public void test() {
    /*
  Example 1:
  Input: ropes = [8, 4, 6, 12]
  Output: 58

  Example 2:
  Input: ropes = [20, 4, 8, 2]
  Output: 54

  Example 3:
  Input: ropes = [1, 2, 5, 10, 35, 89]
  Output: 224

  Example 4:
  Input: ropes = [2, 2, 3, 3]
  Output: 20
     */

    int[] example1 = {8, 4, 6, 12};
    assertEquals(minCostConnectRopes.minCost(example1), 58);

    int[] example2 = {20, 4, 8, 2};
    assertEquals(minCostConnectRopes.minCost(example2), 54);

    int[] example3 = {1, 2, 5, 10, 35, 89};
    assertEquals(minCostConnectRopes.minCost(example3), 224);

    int[] example4 = {2, 2, 3, 3};
    assertEquals(minCostConnectRopes.minCost(example4), 20);
  }

}