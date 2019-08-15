package br.com.drborsato;

import java.util.LinkedList;
import java.util.Queue;

import br.com.drborsato.datastructure.Pair;

/**
 * Author: Daniel Borsato Date: 8/14/19
 */
public class BuildingDemolition {

  public static int minimumDistance(int[][] lot) {
    /*
    start on top left (0,0)
    can move in 1
    cannot move in 0
    destination is 9
     */

    //lot.length - number of lines
    //lot[i] - number of columns of the 'i' line

    Queue<Pair> building = new LinkedList<>();
    building.add(new Pair(0, 0, 0));
    while (!building.isEmpty()) {

      Pair position = building.poll();
      int value = lot[position.getX()][position.getY()];

      //destination found
      if (value == 9) {
        return (int) position.getDistance();
      }

      if (value != 1) continue;

      System.out.println(position + " + " + value);

      lot[position.getX()][position.getY()] = -1; //marking as visited

      //move up
      if (position.getX() - 1 >= 0) {
        building.add(new Pair(position.getX() - 1, position.getY(), (int) (position.getDistance() + 1)));
      }

      //move down
      if (position.getX() + 1 < lot.length) {
        building.add(new Pair(position.getX() + 1, position.getY(), (int) (position.getDistance() + 1)));
      }

      //move left
      if (position.getY() - 1 >= 0) {
        building.add(new Pair(position.getX(), position.getY() - 1, (int) (position.getDistance() + 1)));
      }

      //move right
      if (position.getY() + 1 < lot[position.getX()].length ) {
        building.add(new Pair(position.getX(), position.getY() + 1, (int) (position.getDistance() + 1)));
      }

    }

    return -1;
  }

  public static void main(String[] args) {
    /*
    1 0 0
    1 0 0
    1 9 1
    3
     */
    int lot[][] = {{1, 0, 0}, {1, 0, 0}, {1, 9, 1}};

    /*
    1 0 0 9
    1 0 0 1
    1 0 0 1
    1 1 1 1
    9
     */
    int lot1[][] = {{1, 0, 0, 9}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}};
    System.out.println(minimumDistance(lot1));

    /*
    1 0 0 9
    1 0 0 0
    1 0 0 1
    1 1 1 1
    -1
     */
    int lot2[][] = {{1, 0, 0, 9}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
  }
}
