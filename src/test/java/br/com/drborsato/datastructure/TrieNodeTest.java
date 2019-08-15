package br.com.drborsato.datastructure;

import org.junit.jupiter.api.Test;

/**
 * Author: Daniel Borsato Date: 8/15/19
 */
public class TrieNodeTest {

  @Test
  public void test() {
    TrieNode trieNode = new TrieNode();
    trieNode.add("hack");
    trieNode.add("hackerrank");
    System.out.println(trieNode.get("hac"));
    System.out.println(trieNode.get("hak"));
  }

}
