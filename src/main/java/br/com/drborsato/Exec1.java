package br.com.drborsato;

import javafx.util.Pair;

import java.util.Stack;

//23280666697481
public class Exec1 {


    static int maxNeighbors(int[][] board) {
        int max = 0;

        boolean[][] hasVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            System.out.println("i: " + i);
            for (int j = 0; j < board[i].length; j++) {
                System.out.println("j: " + j);
                if (hasVisited[i][j]) {
                    continue;
                }
                int currentNeighbors = 1;
                Stack neighbors = new Stack();
                neighbors.push(new Pair(i, j));

                while (!neighbors.empty()) {
                    Pair currentPosition = (Pair) neighbors.pop();
                    int currentI = (int) currentPosition.getKey();
                    int currentJ = (int) currentPosition.getValue();
                    System.out.println("currentPosition: i: " + currentI + " j: " + currentJ);
                    hasVisited[currentI][currentJ] = true;

                    //moveUp
                    if (currentI - 1 >= 0 && !hasVisited[currentI - 1][currentJ] && board[currentI - 1][currentJ] == board[i][j]) {
                        System.out.println("moving up");
                        neighbors.push(new Pair(currentI - 1, currentJ));
                        currentNeighbors++;
                    }

                    //moveDown
                    if (currentI + 1 < board.length && !hasVisited[currentI + 1][currentJ] && board[currentI + 1][currentJ] == board[i][j]) {
                        System.out.println("moving down");
                        neighbors.push(new Pair(currentI + 1, currentJ));
                        currentNeighbors++;
                    }

                    //moveRight
                    if (currentJ - 1 >= 0 && !hasVisited[currentI][currentJ - 1] && board[currentI][currentJ - 1] == board[i][j]) {
                        System.out.println("moving right");
                        neighbors.push(new Pair(currentI, currentJ - 1));
                        currentNeighbors++;
                    }

                    //moveLeft
                    if (currentJ + 1 < board[currentI].length && !hasVisited[currentI][currentJ + 1] && board[currentI][currentJ + 1] == board[i][j]) {
                        System.out.println("moving left");
                        neighbors.push(new Pair(currentI, currentJ + 1));
                        currentNeighbors++;
                    }
                }

                if (currentNeighbors > max) {
                    max = currentNeighbors;
                    System.out.println("max = " + max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 2, 3}, {1, 2, 3, 3, 3}, {0, 2, 2, 3, 2}, {1, 2, 3, 3, 1}, {0, 3, 1, 2, 1}};
        System.out.println(maxNeighbors(board));
    }
}
