package br.com.drborsato;

import java.util.LinkedList;
import java.util.Queue;

//import br.com.drborsato.datastructure.Pair;

/**
 * Author: Daniel Borsato Date: 8/24/19
 */
public class FindMinMaxIndex {

    public static int[] findMinMaxIndex(int[] arr, int target) {

        int[] minMax = new int[]{-1, -1};

        int i = 0, j = arr.length - 1;
        while (i < j) {
            System.out.println(i + " " + j);
            if (arr[i] > target && arr[j] < target) {
                break;
            }
            int half = ((j + i) / 2);
            if (arr[half] < target) {
                i = half + 1;
            } else {
                j = half;
            }
        }

        if (arr[i] != target) {
            return minMax;
        } else {
            minMax[0] = i;
        }

        j = arr.length - 1;
        while (i < j) {
            System.out.println(i + " " + j);
            int half = ((j + i) / 2) + 1;
            if (arr[half] > target) {
                j = half - 1;
            } else {
                i = half;
            }
        }
        minMax[1] = j;

        return minMax;
    }

    public static void main(String[] args) {
        int[] firstSolution = findMinMaxIndex(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(firstSolution[0] + " - " + firstSolution[1]);
        int[] secondSolution = findMinMaxIndex(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(secondSolution[0] + " - " + secondSolution[1]);

    }
}