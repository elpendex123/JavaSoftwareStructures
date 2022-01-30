package chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface BagADT {
    void add(Object element);

    Object removeRandom() throws EmptyBagException;

    Object remove(Object element) throws EmptyBagException, NoSuchElementException;

    BagADT union(BagADT set);

    boolean contains(Object target);

    boolean equals(BagADT bag) throws EmptyBagException;

    boolean isEmpty();

    int size();

    @SuppressWarnings("rawtypes")
    Iterator iterator();

    String toString();
}
