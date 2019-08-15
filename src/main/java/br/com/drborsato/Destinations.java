package br.com.drborsato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.drborsato.datastructure.Pair;

/**
 * Author: Daniel Borsato Date: 8/14/19
 */
public class Destinations {

  public static void closestDestinations(int numDestinations, List<Pair> allLocations,
                                         int numDeliveries) {
    allLocations.forEach(pair -> System.out.println(pair));
    Collections.sort(allLocations);
    System.out.println("");
    allLocations.forEach(pair -> System.out.println(pair));
    System.out.println("");
    for (int i = 0; i < numDeliveries; i++) {
      System.out.println(allLocations.get(i));
    }
  }

  public static void main(String[] args) {
    int numDestinations = 3;
    int numDeliveries = 2;
//    allLocations=[(1,2),(3,4),(1,-1)]
    List<Pair> allLocations = new ArrayList<>();
    allLocations.add(new Pair(1,2));
    allLocations.add(new Pair(3,4));
    allLocations.add(new Pair(1,-1));
    closestDestinations(numDestinations,allLocations, numDeliveries);
    //output = [(1,-1),(1,2)
  }
}
