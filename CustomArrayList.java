package com.company.programs;

import java.util.ArrayList;

public class CustomArrayList<T> extends ArrayList<T> {

  public boolean addElement(T e) {
    add(e);
    return true;
  }

  public T get() {
    return get(0);
  }
}
