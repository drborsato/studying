package br.com.drborsato.datastructure;

/**
 * Author: Daniel Borsato Date: 8/14/19
 */
public class Pair implements Comparable<Pair> {

  private int x;
  private int y;
  private double distance;

  public Pair() {
  }

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
    this.distance = distance();
  }

  public Pair(int x, int y, int distance) {
    this.x = x;
    this.y = y;
    this.distance = distance;
  }

  public double distance(){

    return Math.sqrt(x*x+y*y);
  }


  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public double getDistance() {
    return distance;
  }

  public void addDistance() {
    this.distance++;
  }

//
  //  a negative integer, zero, or a positive integer as this object
//        is less than, equal to, or greater than the specified object.
  @Override
  public int compareTo(Pair o) {
    if (distance > o.getDistance())
      return 1;
    if (distance < o.getDistance())
      return -1;
    return 0;
  }

  @Override
  public String toString() {
    return "Pair{" +
           "x=" + x +
           ", y=" + y +
           ", distance=" + distance +
           '}';
  }
}
