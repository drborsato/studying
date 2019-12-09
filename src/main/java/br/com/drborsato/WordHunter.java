package br.com.drborsato;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import javafx.util.Pair;


/**
 * Author: Daniel Borsato Date: 8/20/19
 */
public class WordHunter {

  /*
  Given a 2D board of characters and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
cells are those horizontally or vertically neighboring. The same letter cell may not
 be used more than once.

For example, given the following board:

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.
   */

  public static boolean exists(char[][] board, String word) {

    boolean[][] hasVisited = new boolean[board.length][board[0].length];

    List<Pair> initialNode = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          initialNode.add(new Pair(i, j));
        }
      }
    }

    for (Pair pair : initialNode) {
      Stack possibleMatches = new Stack();
      possibleMatches.push(pair);
      char[] remainingChars = word.toCharArray();
      int actualSize = 0;

      while (!possibleMatches.empty()) {
        Pair thisPosition = (Pair) possibleMatches.pop();
        int i = (int) thisPosition.getKey();
        int j = (int) thisPosition.getValue();
        char charToCompare = board[i][j];

        //mark as visited
        hasVisited[i][j] = true;

        if (remainingChars[actualSize] == charToCompare) {
          actualSize++;
          if (actualSize == word.length()) {
            return true;
          }

          //adding up
          if (i - 1 >= 0 && !hasVisited[i - 1][j]) {
            possibleMatches.push(new Pair(i - 1, j));
          }

          //adding down
          if (i + 1 < board.length && !hasVisited[i + 1][j]) {
            possibleMatches.push(new Pair(i + 1, j));
          }

          //adding left
          if (j - 1 >= 0 && !hasVisited[i][j - 1]) {
            possibleMatches.push(new Pair(i, j - 1));
          }

          //adding right
          if (j + 1 < board[i].length && !hasVisited[i][j + 1]) {
            possibleMatches.push(new Pair(i, j + 1));
          }
        }
      }
      hasVisited = new boolean[board.length][board[0].length];
    }

    return false;

  }

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'},
                      {'S', 'F', 'C', 'S'},
                      {'A', 'D', 'E', 'E'}};

    System.out.println(exists(board, "ABCCED"));
    System.out.println(exists(board, "SEE"));
    System.out.println(exists(board, "ABCB"));
  }

}
