package br.com.drborsato;

import java.util.ArrayList;
import java.util.List;

import br.com.drborsato.datastructure.TrieNode;

/**
 * Author: Daniel Borsato Date: 8/13/19
 */
public class Contacts {
  /*
       * Complete the contacts function below.
       */
  static int[] contacts(String[][] queries) {
    TrieNode trie = new TrieNode();
    List<Integer> contacts = new ArrayList<>();
    for (int i = 0; i < queries.length; i++) {
      System.out.println(queries[i][0] + " : " + queries[i][1]);
      if (queries[i][0].equals("add")) {
        trie.add(queries[i][1]);
      } else {
        Integer times = trie.get(queries[i][1]);
        contacts.add(times);
      }
    }
    int[] toReturn = new int[contacts.size()];
    for (int i = 0; i < contacts.size(); i++) {
      toReturn[i] = contacts.get(i);
    }
    return toReturn;
  }

//  private static final Scanner scanner = new Scanner(System.in);
//
//  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    int queriesRows = Integer.parseInt(scanner.nextLine().trim());
//
//    String[][] queries = new String[queriesRows][2];
//
//    for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
//      String[] queriesRowItems = scanner.nextLine().split(" ");
//
//      for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
//        String queriesItem = queriesRowItems[queriesColumnItr];
//        queries[queriesRowItr][queriesColumnItr] = queriesItem;
//      }
//    }
//
//    int[] result = contacts(queries);
//
//    for (int resultItr = 0; resultItr < result.length; resultItr++) {
//      bufferedWriter.write(String.valueOf(result[resultItr]));
//
//      if (resultItr != result.length - 1) {
//        bufferedWriter.write("\n");
//      }
//    }
//
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();
//  }
}