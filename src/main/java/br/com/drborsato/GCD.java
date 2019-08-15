package br.com.drborsato;

/**
 * Author: Daniel Borsato Date: 8/15/19
 */
public class GCD {
  public int generalizedGCD(int num, int[] arr)
  {
    int gcd = 1;

    //finding max
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    //calculating gcd
    for (int i = 1; i <= max; i++) {
      int newGcd = i;
      boolean hasNewGcd = true;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] % newGcd != 0) {
          hasNewGcd = false;
          break;
        }
      }
      if (hasNewGcd) {
        gcd = newGcd;
      }
    }
    return gcd;
  }
}
