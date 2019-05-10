package br.com.drborsato.datastructure;

/**
 * Author: Daniel Borsato
 * Date: 5/9/19
 */
public class ArrayList<T> implements List<T> {

  private static final int INTITIAL_CAPACITY = 10;
  private Object[] data;
  private int size;

  public ArrayList() {
    size = 0;
    data = new Object[INTITIAL_CAPACITY];
  }

  public ArrayList(int capacity) {
    size = 0;
    data = new Object[capacity];
  }

  public int size() {
    return size;
  }

  public void add(Object o) {
    ensureCapacity();
    data[size] = o;
    size++;
  }

  private void ensureCapacity() {
    if (data.length == size) {
      Object[] newData = new Object[size*2];
      for (int i=0; i<size; i ++) {
        newData[i] = data[i];
      }
      data = newData;
    }
  }

  public void add(int index, Object o) {
    data[index] = o;
  }

  public T get(int index) {
    return (T) data[index];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void remove(int index) {
    data[index] = null;
  }
}
