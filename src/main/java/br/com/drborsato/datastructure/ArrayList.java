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

  public void add(int index, Object o) {
    ensureCapacity();
    checkIndex(index-1);//It is possible to add in last position, which will be data[index]
    data[index] = o;
    size++;
  }

  public T get(int index) {
    checkIndex(index);
    return (T) data[index];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void remove(int index) {
    checkIndex(index);
    data[index] = null;
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

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new ArrayIndexOutOfBoundsException("Check your index dude!");
  }
}
