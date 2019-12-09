package br.com.drborsato;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Daniel Borsato Date: 12/9/19
 */
public class CodilityDemo {

  /*
  Write a function:

  class Solution { public int solution(int[] A); }

  that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

  For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

  Given A = [1, 2, 3], the function should return 4.

  Given A = [−1, −3], the function should return 1.

  Write an efficient algorithm for the following assumptions:

  N is an integer within the range [1..100,000];
  each element of array A is an integer within the range [−1,000,000..1,000,000].
   */

  public static int solution(int[] A) {
    Map<Integer, Boolean> arr = new HashMap<>();
    int higherPossiblePositive = A.length + 1;
    for (int i = 0; i < A.length; i++) {
      arr.put(A[i], Boolean.TRUE);
    }
    for (int i = 1; i <= A.length; i++) {
      if (!arr.containsKey(i)) {
        return i;
      }
    }
    return higherPossiblePositive;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[] {1,3,6,4,1,2}));
    System.out.println(solution(new int[] {1,2,3}));
    System.out.println(solution(new int[] {-1,-3}));
  }

}
