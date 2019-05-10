package br.com.drborsato.datastructure;

/**
 * Author: Daniel Borsato
 * Date: 5/9/19
 */
public interface List<T> {
  int size();
  void add(T t);
  void add(int index, T t);
  T get(int index);
  boolean isEmpty();
  void remove(int index);
}
