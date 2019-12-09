package br.com.drborsato;

import java.util.Stack;

/**
 * Author: Daniel Borsato Date: 8/23/19
 */
public class FindTheLargestColor {


  public static void main(String[] args) {
    int[][]
        board =
        new int[][]{{0, 0, 1, 2, 3}, {1, 2, 3, 3, 3}, {0, 2, 2, 3, 2}, {1, 2, 3, 3, 1},
                    {0, 3, 1, 2, 1}};
    int maxNeighbor = findNeighbor(board);
    System.out.println(maxNeighbor);
  }

  private static int findNeighbor(int[][] board) {


    //board.length = [n][]
    //board[i].length = [][n]

    // 0 1
    // 0 1 2
    // 0 1 2
    // .length = 3
    //[0].length = 2
    //[1].length = 3
    //[2].length = 3

    Stack positions = new Stack();
    boolean[][] hasVisited = new boolean[board.length][board[0].length];
    int max = 1;
    int maxPartial = 1;

    /*

    0 0 1 2 3
    1 2 3 3 3
    0 2 2 3 2
    1 2 3 3 1
    0 3 1 2 1

     */

    for (int l = 0; l < 5; l++) {
      for (int c = 0; c < 5; c++) {
        positions.push(board[l][c]);
        int column = c;
        int line = l;
        System.out.println("Step -> [" + line + "]" + "[" + column + "]");
        while (!positions.isEmpty()) {
          System.out.println("vendo -> [" + line + "]" + "[" + column + "]");
          if (column + 1 < 5 && !hasVisited[line][column + 1] && board[line][column + 1] == Integer
              .parseInt(positions.peek().toString())) {//can move right
            System.out.println("add -> [" + line + "]" + "[" + column + "+1]");
            positions.push(board[line][column + 1]);
            hasVisited[line][column + 1] = true;
            column++;
            maxPartial++;
          } else if (column - 1 > 0 && !hasVisited[line][column - 1]
                     && board[line][column - 1] == Integer
              .parseInt(positions.peek().toString())) {//move left
            System.out.println("add -> [" + line + "]" + "[" + column + "-1]");
            positions.push(board[line][column - 1]);
            hasVisited[line][column - 1] = true;
            column--;
            maxPartial++;
          } else if (line + 1 < 5 && !hasVisited[line + 1][column]
                     && board[line + 1][column] == Integer
              .parseInt(positions.peek().toString())) {//move down
            System.out.println("add -> [" + line + "+1]" + "[" + column + "]");
            positions.push(board[line + 1][column]);
            hasVisited[line + 1][column] = true;
            line++;
            maxPartial++;

          } else {
            System.out.println("Remove -> [" + line + "]" + "[" + column + "]");
            positions.pop();//remove item
          }
        }
        if (maxPartial > max) {
          max = maxPartial;
          maxPartial = 1;
        }
      }
    }
    return max;
  }

}
