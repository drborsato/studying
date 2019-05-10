package br.com.drborsato.datastructure;

/**
 * Author: Daniel Borsato
 * Date: 5/9/19
 */
public class LinkedList<T> implements List<T> {

  private int size;
  private Node<T> head;
  private Node<T> tail;

  public LinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  public void add(Object o) {
    Node nextTail = new Node(o);
    tail.setNext(nextTail);
    tail = nextTail;
    if (head == null) {
      head = nextTail;
    }
    size++;
  }

  public void add(int index, Object o) {
    if (index == size) {
      add(o);
    } else {
      checkIndex(index);
      Node nodeToAdd = new Node(o);
      Node previousNode = getPreviousNode(index);
      nodeToAdd.setNext(previousNode.getNext());
      previousNode.setNext(nodeToAdd);
    }
  }

  public T get(int index) {
    Node node = getNode(index);
    return (T) node.getData();
  }

  private Node getNode(int index) {
    checkIndex(index);
    Node nextNode = head;
    for (int i = 0; i < index; i++) {
      nextNode = nextNode.getNext();
    }
    return nextNode;
  }

  public boolean isEmpty() {
    return size==0;
  }

  public void remove(int index) {
    checkIndex(index);

    Node previousNode = getPreviousNode(index);
    Node nodeToRemove = previousNode.getNext();
    Node nextNode = nodeToRemove.getNext();

    previousNode.setNext(nextNode);
  }

  private Node getPreviousNode(int index) {
    int previousIndex = index-1;
    return (Node) getNode(previousIndex);
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new ArrayIndexOutOfBoundsException("Check your index dude!");
  }
}
