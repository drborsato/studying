package br.com.drborsato.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Daniel Borsato Date: 8/14/19
 */
public class TrieNode {

  private Character key;
  private Integer value;
  private Map<Character, TrieNode> nodes;

  public TrieNode() {
    nodes = new HashMap<>();
  }

  public TrieNode(Character key) {
    this.key = key;
    this.value = 0;
    nodes = new HashMap<>();
  }

  public Character getKey() {
    return key;
  }

  public void setKey(Character key) {
    this.key = key;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Map<Character, TrieNode> getNodes() {
    return nodes;
  }

  public void setNodes(Map<Character, TrieNode> nodes) {
    this.nodes = nodes;
  }

  public void addValue() {
    this.value++;
  }

  public void add(String s) {
    TrieNode node = nodes.getOrDefault(s.charAt(0), new TrieNode(s.charAt(0)));
    node.addValue();
    if (s.length() > 1)
      node.add(s.substring(1));
    nodes.put(s.charAt(0), node);
  }

  public Integer get(String s) {
    TrieNode node = nodes.get(s.charAt(0));
    if (node == null) return 0;
    if (s.length() == 1) {
      return node.getValue();
    }
    return node.get(s.substring(1));
  }
}
