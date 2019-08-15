package br.com.drborsato.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * Author: Daniel Borsato Date: 8/14/19
 */
public class TreeNode<T> {

  private Object data;
  private TreeNode right;
  private TreeNode left;

  public TreeNode(Object data) {
    this.data = data;
  }

  public int height() {
    if (right == null && left == null) {
      return 0;
    }

    int rightH = right == null ? 0 : right.height();
    int leftH = left == null ? 0 : left.height();

    if (rightH > leftH) {
      return rightH+1;
    }
    return leftH+1;

  }

  public String printLevelOrder() {
    StringJoiner print = new StringJoiner(" ");
    Queue queue = new LinkedList();
    queue.add(data);

    while (!queue.isEmpty()) {
      TreeNode node = (TreeNode) queue.remove();
      print.add(node.getData().toString());
      if (node.getLeft() != null)
        queue.add(node.getLeft());
      if (node.getRight() != null)
        queue.add(node.getRight());
    }

    return print.toString();
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

}
